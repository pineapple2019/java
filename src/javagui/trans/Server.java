package trans;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Calendar;

public class Server extends JFrame implements ActionListener{
    static JTextArea jta=null;
    JTextField jtf=null;
    JScrollPane jsp=null;
    JButton jb_send=null;
    JPanel jp=null;
    static Socket socket=null;
    static String text_message;
    public static void main(String[] args) throws IOException {
        ServerSocket server=null;
        new Server();
        try
        {
            server=new ServerSocket(8001);
            socket=server.accept();
        }
        catch(Exception e)
        {
            System.out.println("不能监听："+e);
        }

        while(true)
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            jta.append(br.readLine()+"\n");
        }
    }


    public Server(){
        jta=new JTextArea();
        jta.setEditable(false);
        jsp=new JScrollPane(jta);
        jtf=new JTextField(20);
        jp=new JPanel();
        jb_send=new JButton("发送");
        jb_send.addActionListener(this);

        jp.add(jtf);
        jp.add(jb_send);
        this.add(jsp,"Center");
        this.add(jp,"South");
        this.setTitle("服务端");
        this.setSize(300, 200);
        this.setLocation(318,186);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb_send)
        {
            if(jtf.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "消息不能为空");
            }
            else
            {
                text_message=jtf.getText();
                jta.append("服务端: "+Calendar.getInstance().getTime().toLocaleString()+" "+text_message+"\n");
                PrintWriter pw;
                try
                {
                    pw = new PrintWriter(socket.getOutputStream(),true);
                    if(!text_message.equals(""))
                    {
                        pw.println("服务端: "+Calendar.getInstance().getTime().toLocaleString()+" "+text_message);
                    }
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                jtf.setText("");
            }
        }
    }
}







