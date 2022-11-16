package component;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        //创建一个框架
        JFrame frame = new JFrame("下拉");
        JPanel jp =new JPanel();    //创建一个面板

        JLabel label1=new JLabel("证件类型");
        JComboBox cmb = new JComboBox();
        cmb.addItem("身份证");
        cmb.addItem("驾驶证");
        cmb.addItem("军官证");

        jp.add(label1); //添加标签
        jp.add(cmb);    //添加选项卡

        frame.add(jp);  //内容添加到框架中
        frame.setBounds(400,400,400,400);//设置大小
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
