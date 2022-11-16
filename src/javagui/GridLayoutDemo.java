package ee.ds;//package GuiLayout;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {
    static final int WIDTH=300;
    static final int HEIGHT=200;
    public static void main(String[] args) {
        JFrame jf = new JFrame("**GridLayout布局管理器**");
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        JPanel contentPane = new JPanel();
        jf.setContentPane(contentPane);

        JButton c1 = new JButton("白菜");
        JButton c2 = new JButton("胡萝卜");
        JButton c3 = new JButton("青菜");
        JButton c4 = new JButton("西红柿");
        JButton c5 = new JButton("土豆");
        JButton c6 = new JButton("白萝卜");
        JButton c7 = new JButton("青菜");
        JButton c8 = new JButton("西红柿");
        JButton c9 = new JButton("土豆");

        GridLayout gird = new GridLayout(3, 3);
        //1，创建一个GridLayout布局管理器
        //2，将其行列数设置为3，3，并且将之作为中间容器的布局管理器
        contentPane.setLayout(gird);
        contentPane.add(c1);
        contentPane.add(c2);
        contentPane.add(c3);
        contentPane.add(c4);
        contentPane.add(c5);
        contentPane.add(c6);
        contentPane.add(c7);
        contentPane.add(c8);
        contentPane.add(c9);

        jf.pack();

    }
}

