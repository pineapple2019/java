package com.one.container;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TestListen {
    public static void main(String[] args) {
        JFrame jf=new JFrame("监听事件测试");
        //流布局，左对齐
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setBounds(400,300,300,300);
        //设置文本框大小
        JTextArea area=new JTextArea(10,20);

        //设置自动换行
        area.setLineWrap(true);
        JButton button =new JButton("暴打马老师");

        //添加监听事件
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //   area.setText("年轻人好自为之");//这个会覆盖之前的内容
                area.append("年轻人好自为之");
            }
        });
        //内容添加到容器
        jf.add(area);
        jf.add(button);
        //设置为可见
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
