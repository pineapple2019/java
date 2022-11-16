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

        //��װ��ͼ����ʾ�����м�
        this.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
//        JPanel JP= new JPanel();


//        jf.setContentPane(JP);
//����һ�����ϵ�����ʾ������� Box������봴��һ�����ظ��������� Box����Ӧʹ�ù��췽��������
        Box vBox = Box.createVerticalBox();
        //�����ͻ��˵�Socket����(Socket)
        //Socket s = new Socket("localhost", 10090);
 /*
 ���5����Դ
  */
        Choice cc = new Choice();
        cc.add("������Դ");
        cc.add("�洢��Դ");
        cc.add("������Դ");
        cc.add("������Դ");
        cc.add("������Դ");

        //��װͼ������
        Box nameBox = Box.createHorizontalBox();    //����һ����������ʾ������� Box
//        JLabel nameLable = new JLabel("���Ӳ�������");
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
        //��װ������
        Box stockBox = Box.createHorizontalBox();
//        JLabel stockLable = new JLabel("������");
        JLabel stockLable = new JLabel("����");

        JTextField stockField = new JTextField(15);

        stockBox.add(stockLable);
        stockBox.add(Box.createHorizontalStrut(20));
        stockBox.add(stockField);

        //��װ�״�
        Box authorBox = Box.createHorizontalBox();
//        JLabel authorLable = new JLabel("�״�");
        JLabel authorLable = new JLabel("����");
        JTextField authorField = new JTextField(15);

        authorBox.add(authorLable);
        authorBox.add(Box.createHorizontalStrut(20));
        authorBox.add(authorField);

        //��װѡ��1
        Box priceBox = Box.createHorizontalBox();
        JLabel priceLable = new JLabel("ѡ��1");
        JTextField priceField = new JTextField(15);

        priceBox.add(priceLable);
        priceBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceField);

        //��װѡ��2
        Box descBox = Box.createHorizontalBox();
        JLabel descLable = new JLabel("ѡ��2");
        JTextField descField = new JTextField(15);

        descBox.add(descLable);
        descBox.add(Box.createHorizontalStrut(20));
        descBox.add(descField);

        //��װ���
        Box btnBox = Box.createHorizontalBox();
        JButton addBtn = new JButton("���");
        btnBox.add(addBtn);
        //�Ǹ�null�Ǹ��ര��
//        JOptionPane.showMessageDialog(null, "�������ʾ��", "Title",JOptionPane.PLAIN_MESSAGE);
        /*
             ͨ�����¼�������û��Ľ���
         */

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               /*
                    ��ȡ�û���¼��
                    trim() ��������ɾ���ַ�����ͷβ�հ׷���
                    ���������������̨
                getText������ȡ����
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
                 * BufferedWriter,�ַ���������
                 * OutputStreamWriter��InputStreamReader�ַ������������д�� write��flushˢ����
                 *����tcp���ԣ�����������
                 * outputstream��inputstream�е�
                 * getOutputStream��getInputStream
                 *
                 */

                BufferedWriter bw = null;

                try {
                    bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//                    bw.write("hello,world"); //дһ��
//                    bw.write(ctext); //дһ��
//                    bw.newLine();   //����
//                    bw.write(name+" "); //дһ��
//                    bw.newLine();   //����
                    bw.write(stock+" "); //дһ��
//                  bw.newLine();   //����
                    bw.write(author+" "); //дһ��
//                  bw.newLine();   //����
//                  bw.write(price+" "); //дһ��
//                  bw.newLine();   //����
//                  bw.write(desc+" ");
//                  bw.write("java,hello");

                    bw.flush(); //ˢ��

//                   this.dispose();
//                   jf.dispose();   //�����������Ĵ���ر��ˣ�Ȼ�������û�йر�

                    //�ͷ���Դ

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                //���ʺ�̨�ӿ�
                JOptionPane.showMessageDialog(null, "��ӳɹ�", "Title",JOptionPane.PLAIN_MESSAGE);
                try {
                    s.close();      //���û����仰����ô��ֻ�������һ�������Ĳ�������������Ĳ���������������ͽ��ղ�������
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
        //Ϊ�������м�࣬��vBox����װһ��ˮƽ��Box����Ӽ��
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(vBox);
        hBox.add(Box.createHorizontalStrut(20));
        this.add(hBox);
    }

//    private void addBox01(Box nameBox, JLabel nameLable, JTextField nameField) {

//    }
}
