package trans;

import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener{
    static JTextArea jta=null;
    JTextField jtf=null;
    JPanel jp=null;
    JButton jb_send=null;
    JScrollPane jsp=null;
    static String text_message;
    static Socket socket=null;
    public static void main(String[] args) throws IOException {
        new Client();
        socket=new Socket("127.0.0.1",8001);
        while(true)
        {
            BufferedReader is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            jta.append(is.readLine()+"\n");
        }
    }


    public Client()
    {
        jta=new JTextArea();
        jta.setEditable(false);
        jtf=new JTextField(20);
        jb_send=new JButton("发送");
        jb_send.addActionListener(this);
        jp=new JPanel();
        jsp=new JScrollPane(jta);
        jp.add(jtf);
        jp.add(jb_send);

        this.add(jsp,"Center");
        this.add(jp,"South");
        this.setTitle("客户端");
        this.setSize(300, 200);
        this.setLocation(636,186);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==jb_send)
        {
            if(jtf.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "消息不能为空");
            }
            else
            {
                text_message=jtf.getText();
                try
                {
                    PrintWriter pw=null;
                    pw=new PrintWriter(Client.socket.getOutputStream(),true);
                    if(!text_message.equals(""))
                    {
                        pw.println("客户端: "+Calendar.getInstance().getTime().toLocaleString()+" "+text_message);
                    }
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
                jta.append("客户端: "+Calendar.getInstance().getTime().toLocaleString()+" "+text_message+"\n");
                jtf.setText("");
            }
        }
    }
}
