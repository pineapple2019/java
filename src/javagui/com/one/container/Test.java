package com.one.container;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {
    JFrame myframe = new JFrame();
    JLabel label1 = new JLabel("label1");
    JLabel label2 = new JLabel("label2");
    JButton button1 = new JButton("确定");
    JButton button2 = new JButton("取消");
    public void init() {
        myframe.setSize(300, 200);
        myframe.getContentPane().setLayout(null);
        myframe.setTitle("java 小程序");
        label1.setBounds(20, 20, 120, 27);
        label2.setBounds(20, 40, 120, 27);
        button1.setBounds(20, 60, 60, 27);
        button2.setBounds(100, 60, 60, 27);


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label1.setText("你点了确定");
            }
        });


        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setText("你点了取消");
            }
        });


        myframe.add(label1);
        myframe.add(label2);
        myframe.add(button1);
        myframe.add(button2);
        myframe.show();
    }
    public static void main(String[] args) {
        new Test().init();
    }
}