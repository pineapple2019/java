package com.one.container;

import javax.swing.*;
import java.awt.*;

public class LoginDemo {
    public static void main(String[] args) {
        JFrame jf=new JFrame("登录");

        //必须设置布局方式，要不然就不显示,这两句必须有
        //从左到右流布局，最里面的left是对齐方式
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        //设置窗口大小和尺寸
        jf.setBounds(460,300,300,200);


        JLabel label1=new JLabel("账号");
        JTextField usernameText=new JTextField("",23);
        JLabel label2=new JLabel("密码");
        JPasswordField pwdText =new JPasswordField("",23);

        //添加接下来的内容
        JTextField out=new JTextField("登录状态",25);
        JButton button =new JButton("登录");

        //按顺序依次把内容添加到容器中，要不然会看不到内容
        jf.add(label1);
        jf.add(usernameText);
        jf.add(label2);
        jf.add(pwdText);
        jf.add(out);
        jf.add(button);



        //设置不可调节大小
        jf.setResizable(false);
        //设置按钮大小

        //设置可见
        jf.setVisible(true);
        //设置关闭方式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }
}
