package component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

//box里面没有空参构造，需要重写其构造函数
public class BookManageComponent extends Box {
    final int WIDTH=850;
    final int HEIGHT=600;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private DefaultTableModel tableModel;   //因为要操纵增删改查，所以用数据模型比较方便

    public BookManageComponent(JFrame jf) {
//    public BookManageComponent() {
        //垂直布局
        super(BoxLayout.Y_AXIS);
        //组装视图
        this.jf=jf;
        JPanel btnPanel = new JPanel();
        //设置颜色
//        Color color = new Color(203,220,217);
//        btnPanel.setBackground(color);

        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addBtn = new JButton("添加");
        JButton updateBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket s = null;
                try {
                    s = new Socket("localhost", 10100);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //弹出一个对话框，让用户输入图书信息
                new AddBookDialog(jf,"添加操作",true,s).setVisible(true);
            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        this.add(btnPanel);
        //组装表格
        String[] ts = {"编号","书名","简介","作者","价格","库存"};
        titles = new Vector<>();
        for(String title:ts){
            titles.add(title);       //把title放到集合中
        }

        //此时里面没有数据，所以要请求数据
        tableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData,titles);

        table = new JTable(tableModel){
            @Override      //设置为不可编辑
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //设置只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //没有标题是因为被挤没了，因为会展示最新的数据，所以标题挤没了，虽然这里面也没有数据

        //this.add(table);    //表格里还没有数据

        //用JScrollPane把table包装一下
         /*
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        */


        // requestData();

        //请求数据，
//        public void requestData(){
//            GetUtils.get("http://localhost:8080/book/findAllBook", new SuccessListener() {
//                @Override
//                public void success(String result) {
//                    ResultInfo info = JsonUtils.parseResult(result);
//                    Vector<Vector> vectors = ResultInfoData2Vector.convertResultInfoData2Vector(info);
//
//                    //清空tableData的数据
//                    tableData.clear();
//                    for (Vector vector : vectors) {
//                        tableData.add(vector);
//                    }
//
//                    //刷新表格
//                    tableModel.fireTableDataChanged();
//                }
//            }, new FailListener() {
//                @Override
//                public void fail() {
//
//                }
//            });
//        }


    }
}





