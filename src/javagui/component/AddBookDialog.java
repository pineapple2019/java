package component;
import util.ScreenUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
public class AddBookDialog extends JDialog {
    final int WIDTH = 400;
    final int HEIGHT = 300;
    //    public AddBookDialog(JFrame jf, String title, boolean isModel) {
    public AddBookDialog(JFrame jf, String title, boolean isModel,Socket s) {
//        super(jf, title, isModel);

        //组装视图，显示到正中间
        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
//        JPanel JP= new JPanel();


//        jf.setContentPane(JP);
//创建一个从上到下显示其组件的 Box。如果想创建一个遵守该组件方向的 Box，则应使用构造方法并传入
        Box vBox = Box.createVerticalBox();
        //创建客户端的Socket对象(Socket)
        //Socket s = new Socket("localhost", 10090);
 /*
 添加5种资源
  */
        Choice cc = new Choice();
        cc.add("传感资源");
        cc.add("存储资源");
        cc.add("武器资源");
        cc.add("网络资源");
        cc.add("计算资源");

        //组装图书名称
        Box nameBox = Box.createHorizontalBox();    //创建一个从左到右显示其组件的 Box
//        JLabel nameLable = new JLabel("增加操作名称");
        /**
         * case "addObject":
         *                 addObject();
         *                 break;
         *             case "addClass":
         *                 addClass();
         *                 break;
         *             case "addDataProperty":
         *                 addDataPropertyForObject();
         *                 break;
         *             case "addSubClass":
         *                 addSubClass();
         *                 break;
         *             case "addObjectProperty":
         *                 addObjectProperty();
         *                 break;
         *             case "addDataPropertyDomain":
         *                 addDataPropertyDomain();
         *                 break;
         *             case "addObjectPropertyDomain":
         *                 addObjectPropertyDomain();
         */

        Choice c2 = new Choice();
        c2.add("addObject");
        c2.add("addClass");
        c2.add("addDataProperty");
        c2.add("addSubClass");
        c2.add("addObjectProperty");
        c2.add("addDataPropertyDomain");
        c2.add("addObjectPropertyDomain");

//        JTextField nameField = new JTextField(15);

//        addBox01(nameBox, nameLable, nameField);
//        addBox01(nameBox,c2,nameField);
//        nameBox.add(nameLable);
        nameBox.add(c2);
        nameBox.add(Box.createHorizontalStrut(20));
//        nameBox.add(nameField);
        //组装传感器
        Box stockBox = Box.createHorizontalBox();
//        JLabel stockLable = new JLabel("传感器");
        JLabel stockLable = new JLabel("导弹");

        JTextField stockField = new JTextField(15);

        stockBox.add(stockLable);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);

        //组装雷达
        Box authorBox = Box.createHorizontalBox();
//        JLabel authorLable = new JLabel("雷达");
        JLabel authorLable = new JLabel("火炮");
        JTextField authorField = new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        //组装选填1
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLable = new JLabel("选填1");
        JTextField priceField = new JTextField(15);

        priceBox.add(priceLable);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);

        //组装选填2
        Box descBox = Box.createHorizontalBox();
        JLabel descLable = new JLabel("选填2");
        JTextField descField = new JTextField(15);

        descBox.add(descLable);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(descField);

        //组装添加
        Box btnBox = Box.createHorizontalBox();
        JButton addBtn = new JButton("添加");
        btnBox.add(addBtn);
        //那个null是父类窗口
//        JOptionPane.showMessageDialog(null, "最基本提示框", "Title",JOptionPane.PLAIN_MESSAGE);
        /*
             通过该事件，完成用户的交互
         */

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /*
                    获取用户的录入
                    trim() 方法用于删除字符串的头尾空白符。
                    将内容输出到控制台
                getText用来获取内容
                */

//              String ctext = cc.getSelectedItem();
//                String name = nameField.getText().trim();
                String stock = stockField.getText().trim();
                String author = authorField.getText().trim();
//                String price = priceField.getText().trim();
//                String desc = descField.getText().trim();

//                System.out.println(ctext);
//                System.out.println(name);
                System.out.println(stock);
                System.out.println(author);
//                System.out.println(price);
//                System.out.println(desc);


                /**
                 * BufferedWriter,字符缓冲流，
                 * OutputStreamWriter，InputStreamReader字符输入输出流，写用 write和flush刷新流
                 *对于tcp而言，传送数据用
                 * outputstream和inputstream中的
                 * getOutputStream和getInputStream
                 *
                 */

                BufferedWriter bw = null;

                try {
                    bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//                    bw.write("hello,world"); //写一行
//                    bw.write(ctext); //写一行
//                    bw.newLine();   //换行
//                    bw.write(name+" "); //写一行
//                    bw.newLine();   //换行
                    bw.write(stock+" "); //写一行
//                  bw.newLine();   //换行
                    bw.write(author+" "); //写一行
//                  bw.newLine();   //换行
//                  bw.write(price+" "); //写一行
//                  bw.newLine();   //换行
//                  bw.write(desc+" ");
//                  bw.write("java,hello");

                    bw.flush(); //刷新

//                   this.dispose();
//                   jf.dispose();   //这个把最外面的大框框关闭了，然而里面的没有关闭

                    //释放资源

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                //访问后台接口
                JOptionPane.showMessageDialog(null, "添加成功", "Title",JOptionPane.PLAIN_MESSAGE);
                try {
                    s.close();      //如果没有这句话，那么就只能输出第一行其他的不能输出，其他的不能输出，服务器就接收不到数据
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        vBox.add(cc);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(nameBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(stockBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(authorBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(priceBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(descBox);
        vBox.add(Box.createVerticalStrut(15));
        vBox.add(btnBox);

//        this.add(vBox);
        //为了左右有间距，在vBox外层封装一个水平的Box，添加间隔
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));
        this.add(hBox);
    }

//    private void addBox01(Box nameBox, JLabel nameLable, JTextField nameField) {

//    }
}
