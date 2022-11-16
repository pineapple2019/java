package needPractice;

/*
显示图片
 */
import javax.swing.*;
public class Main
{
    static public void main(String args[])
    {
        JFrame frame=new JFrame();
        frame.setBounds(0,0,500,400);
        ImageIcon image=new ImageIcon("D:\\leidian\\ly.jpg");
        JLabel label=new JLabel(image);
        frame.setLayout(null);
        frame.add(label);
        label.setBounds(0,0,500,400);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}