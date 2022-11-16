package trans;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//创建一个窗体，然后点击这个，就关闭该窗体



public class dispose01 {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                System.out.println("hello");
                System.exit(1);
            }
        });

        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
