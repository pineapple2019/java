package component;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        //����һ�����
        JFrame frame = new JFrame("����");
        JPanel jp =new JPanel();    //����һ�����

        JLabel label1=new JLabel("֤������");
        JComboBox cmb = new JComboBox();
        cmb.addItem("���֤");
        cmb.addItem("��ʻ֤");
        cmb.addItem("����֤");

        jp.add(label1); //��ӱ�ǩ
        jp.add(cmb);    //���ѡ�

        frame.add(jp);  //������ӵ������
        frame.setBounds(400,400,400,400);//���ô�С
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
