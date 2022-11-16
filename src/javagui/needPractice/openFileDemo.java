package needPractice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//
public class openFileDemo {
    public static void main(String[] args) {
        createWindow();

    }

    private static void createWindow() {
        JFrame frame = new JFrame("Swing打开文件对话框(yiibai.com)");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI(frame);

        frame.setSize(560, 200);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }

    private static void createUI(final JFrame frame){
        JPanel panel = new JPanel();

        LayoutManager layout = new FlowLayout();

        panel.setLayout(layout);

        JButton button = new JButton("点击这里开始~");

        final JLabel label = new JLabel();

        button.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int option = fileChooser.showOpenDialog(frame);

                if(option == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();

                    label.setText("选择文件是: " + file.getName());

                }else{
                    label.setText("打开命令取消");

                }

            }

        });

        panel.add(button);

        panel.add(label);

        frame.getContentPane().add(panel, BorderLayout.CENTER);

    }


}
