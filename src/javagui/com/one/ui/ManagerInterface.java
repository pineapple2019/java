//package com.one.ui;
//
//import com.one.util.ScreenUtils;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.io.File;
//
//public class ManagerInterface {
//    JFrame jf = new JFrame("黑马图书馆：Xxx，欢迎您");
//    final int WIDTH = 1000;
//    final int HEIGHT = 600;
//    //组装视图
//    public void init(){
//        //给窗口设置属性
//        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
//
//        jf.setResizable(false);
//        //设置logo
//        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));
//    }
//
//}
