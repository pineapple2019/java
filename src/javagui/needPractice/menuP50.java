package needPractice;

import javax.swing.*;
import java.awt.*;

public class menuP50 {
    JFrame jf=new JFrame("测试Swing基本组件");
    //流布局，左对齐




/*
    声明菜单相关组件
 */
    JMenuBar menuBar =new JMenuBar();

    //一级菜单
    JMenu fileMenu = new JMenu("文件");
    JMenu editMenu = new JMenu("编辑");

    //二级菜单
    JMenuItem openFile = new JMenuItem("打开文件");

    JMenuItem auto = new JMenuItem("自动换行");
    JMenuItem copy = new JMenuItem("复制");
    JMenuItem paste = new JMenuItem("粘贴");
    //一级菜单
    JMenu formatMenu = new JMenu("格式");
    //二级菜单
    JMenuItem comment = new JMenuItem("注释");
    JMenuItem cancelComment = new JMenuItem("取消注释");

/*
    声明文本域
 */

    JTextArea jta=new JTextArea(8,20);




    //初始化界面
    public void init(){
        /*
        流式布局左对齐
         */
        jf.setLayout(new FlowLayout(FlowLayout.LEFT));
        jf.setBounds(400,300,300,300);


        //组装顶部菜单
        jf.setJMenuBar(menuBar);    //这个是什么？？
        //添加一级菜单
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        //添加二级菜单
        fileMenu.add(openFile);

        editMenu.add(auto);
        //添加横线进行区分
        editMenu.addSeparator();

        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.addSeparator();

        editMenu.add(formatMenu);

        formatMenu.add(comment);
        formatMenu.add(cancelComment);


        //设置默认关闭方式，和视图可见
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //jf.pack();   //pack是调整窗口大小，尽量满足每一个组件的最优大小的情况下让窗口最小化。
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new menuP50().init();
    }



}
