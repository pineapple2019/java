package com.one.container;

import javax.swing.*;
import java.awt.*;

public class ChoiceDemo {
        JFrame jf = new JFrame();
        //定义一个下拉选择框
        Choice cc= new Choice();
        public void init() {
        //往下拉选择框中添加内容
        cc.add("红色");
        cc.add("绿色");
        cc.add("蓝色");
        cc.add("金色");
        jf.add(cc);
            //设置frame最佳大小并可见
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ChoiceDemo().init();
    }
}
