package component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.util.Vector;

//box����û�пղι��죬��Ҫ��д�乹�캯��
public class BookManageComponent extends Box {
    final int WIDTH=850;
    final int HEIGHT=600;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private DefaultTableModel tableModel;   //��ΪҪ������ɾ�Ĳ飬����������ģ�ͱȽϷ���

    public BookManageComponent(JFrame jf) {
//    public BookManageComponent() {
        //��ֱ����
        super(BoxLayout.Y_AXIS);
        //��װ��ͼ
        this.jf=jf;
        JPanel btnPanel = new JPanel();
        //������ɫ
//        Color color = new Color(203,220,217);
//        btnPanel.setBackground(color);

        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addBtn = new JButton("���");
        JButton updateBtn = new JButton("�޸�");
        JButton deleteBtn = new JButton("ɾ��");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socket s = null;
                try {
                    s = new Socket("localhost", 10100);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //����һ���Ի������û�����ͼ����Ϣ
                new AddBookDialog(jf,"��Ӳ���",true,s).setVisible(true);
            }
        });

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);
        this.add(btnPanel);
        //��װ���
        String[] ts = {"���","����","���","����","�۸�","���"};
        titles = new Vector<>();
        for(String title:ts){
            titles.add(title);       //��title�ŵ�������
        }

        //��ʱ����û�����ݣ�����Ҫ��������
        tableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData,titles);

        table = new JTable(tableModel){
            @Override      //����Ϊ���ɱ༭
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //����ֻ��ѡ��һ��
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //û�б�������Ϊ����û�ˣ���Ϊ��չʾ���µ����ݣ����Ա��⼷û�ˣ���Ȼ������Ҳû������

        //this.add(table);    //����ﻹû������

        //��JScrollPane��table��װһ��
         /*
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        */


        // requestData();

        //�������ݣ�
//        public void requestData(){
//            GetUtils.get("http://localhost:8080/book/findAllBook", new SuccessListener() {
//                @Override
//                public void success(String result) {
//                    ResultInfo info = JsonUtils.parseResult(result);
//                    Vector<Vector> vectors = ResultInfoData2Vector.convertResultInfoData2Vector(info);
//
//                    //���tableData������
//                    tableData.clear();
//                    for (Vector vector : vectors) {
//                        tableData.add(vector);
//                    }
//
//                    //ˢ�±��
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





