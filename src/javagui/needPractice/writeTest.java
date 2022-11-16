package needPractice;

import com.one.container.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*

如何运用图形界面将数据写入到txt文件中，进而写到xml文件中，进而写到owl文件中，进而使用socket套接字传递到服务器端中
今日任务
1，写一个JTextField，和jnbutton
2，点击按钮获取文本数据
3，创建button中的监听流
4,使用输出流write，将获得的数据写入到txt中

 */
public class writeTest {
    JFrame jf =new JFrame();

    JLabel jl = new JLabel("输入内容");
    JTextField jtf = new JTextField(15);
    JButton button1 = new JButton("确定");

    public void init() {
        jf.setSize(300, 200);
        jf.getContentPane().setLayout(null);
        jf.setTitle("java 小程序");
        jl.setBounds(20, 20, 120, 27);
        button1.setBounds(20, 60, 60, 27);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jl.setText("你点了确定");
            }
        });

        jf.add(jl);
        jf.add(jtf);
        jf.add(button1);
    }

    public static void main(String[] args) {
        new Test().init();
    }

}