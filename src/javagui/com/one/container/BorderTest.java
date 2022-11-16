package com.one.container;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class BorderTest {
    JFrame jf=new JFrame("测试");
    public void init(){
        //1.JFrame的布局修改为GridLayout
        jf.setLayout(new GridLayout(2,4));

        //2.往网格中填充不同的JPanel组件，并且设置边框和内容

        //创建BevelBorder
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.RED, Color.GREEN, Color.BLUE, Color.GRAY);
        jf.add(getJPanelWithBorder(bevelBorder,"BevelBorder"));
    }

    public JPanel getJPanelWithBorder(Border border, String content){
        JPanel jPanel = new JPanel();
        jPanel.add(new JLabel(content));

        //设置边框
        jPanel.setBorder(border);

        return jPanel;
    }

    public static void main(String[] args) {
        new BorderTest().init();
    }

}
