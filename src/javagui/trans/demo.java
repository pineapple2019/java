package trans;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class demo {
    JFrame jf=new JFrame("测试一个窗体");
    JButton jb=new JButton("确定");

    public void init(){
        //设置窗体的大小
        jf.setSize(300,400);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("fasdhukhjbjkahs");
                    jf.dispose();
            }
        });
        jf.add(jb);
        jf.setVisible(true);
        jf.pack();
    }

    public static void main(String[] args) {
        new demo().init();
    }
}
