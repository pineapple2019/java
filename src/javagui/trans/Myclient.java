package trans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Myclient extends JFrame{
    private JButton jb;

    public Myclient(){


        JLabel stockLable = new JLabel("操作数1");
        JTextField stockField = new JTextField(15);


        jb = new JButton("点击");
        this.add(stockLable);
        this.add(stockField);
        this.add(jb);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("积分哈老师傅了");
                JOptionPane.showMessageDialog(Myclient.this, "您好！","消息", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Myclient();
    }
}
