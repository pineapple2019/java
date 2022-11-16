package needPractice;

import javax.swing.*;
import java.awt.*;

public class SplitPaneTest2 {
    //所用到的组件
    JFrame jf = new JFrame("测试");

    JButton B1=new JButton("这个是左边的按钮");

    /*
    右边的图片
     */
//    JFrame frame=new JFrame();
//    frame.setBounds(0,0,500,400);
        ImageIcon image=new ImageIcon("D:\\leidian\\ly.jpg");
        JLabel label=new JLabel(image);
//    jf.setLayout(null);   //setLayout() 是布局管理器，让容器管理Swing组件的摆放位置的。
//    jf.add(label);
//    label.setBounds(0,0,500,400);
//    jf.setVisible(true);
//    jf.setResizable(false);
//
    //组件的组装
    public void init(){
        //创建一个分隔容器类
        JSplitPane sp=new JSplitPane();
        //支持连续布局
        sp.setContinuousLayout(true);
        //分隔线宽度
        sp.setDividerSize(2);
        //分隔线位于中间位置
        sp.setDividerLocation(50);

        sp.setPreferredSize(new Dimension(100,200));
        sp.setLeftComponent(B1);
//        sp.setRightComponent();
        ImageIcon image=new ImageIcon("swingDemo\\img\\2.png");
        JLabel label=new JLabel(image);

        sp.setRightComponent(label);
        jf.setBounds(100,100,400,200);
        jf.add(sp);


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SplitPaneTest2().init();
    }
}
