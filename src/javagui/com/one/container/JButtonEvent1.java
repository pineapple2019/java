package com.one.container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonEvent1 extends JFrame {
    public JButtonEvent1(){
        JButton button=new JButton("测试按钮");
        button.setBounds(30, 60, 30, 30);

        button.addActionListener(new ActionListener() {//匿名内部类

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton)e.getSource()).getText());
            }
        });
        add(button);
    }
    public static void main(String[] args) {
        JButtonEvent1 frame=new JButtonEvent1();
        frame.setTitle("演示动作事件处理");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,300);
        frame.setVisible(true);
    }
}