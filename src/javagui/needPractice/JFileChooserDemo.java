package needPractice;

import javax.swing.*;
import java.awt.*;

public class JFileChooserDemo {
    /*
    创建窗口对象
     */
    JFrame jf = new JFrame("测试打卡文件");

    /*
    创建菜单条
     */
    JMenuBar menuBar = new JMenuBar();
    //一级菜单
    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");

    //二级菜单
    JMenuItem openFile = new JMenuItem("打开文件");
    JMenuItem saveFile = new JMenuItem("文件另存为");

    //初始化界面
    public void init() {
        /*
        流式布局左对齐
         */
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setBounds(400, 300, 300, 300);

       /*
       组装顶部菜单
        */
        //设置菜单栏
        jf.setJMenuBar(menuBar);
        //添加一级菜单
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        //添加二级菜单
        fileMenu.add(openFile);
        //添加横线进行区分
//        editMenu.addSeparator();
        fileMenu.add(saveFile);


        //设置默认关闭方式，和视图可见
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JFileChooserDemo().init();
    }
}
