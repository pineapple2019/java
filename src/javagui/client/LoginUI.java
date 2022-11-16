package client;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class LoginUI extends JFrame{

	private static final long serialVersionUID = 1L;
	JTextField username=new JTextField();
	JTextField password=new JTextField();
	JLabel label1=new JLabel();
	JLabel label2=new JLabel();
	JButton but1=new JButton("登录"); 
	JButton but2=new JButton("退出");
	
	public LoginUI() {
		this.setDefaultCloseOperation(0);
		this.setSize(500, 400);
		this.setTitle("登陆");
		this.setLayout(null);
		this.getContentPane().setBackground(Color.GRAY);
		label1.setText("用户名");
		label1.setBounds(50, 105, 60, 50);
		label1.setFont(new Font("楷体",Font.BOLD,15));
		this.add(label1);
		
        username.setBounds(120, 100,300, 50);
		username.setFont(new Font("宋体",Font.BOLD,18));
		this.add(username);
		
		label2.setText("密  码");
		label2.setBounds(50, 185, 60, 50);
		label2.setFont(new Font("楷体",Font.BOLD,15));
		this.add(label2);
		
		password.setBounds(120, 180, 300, 50);
		password.setFont(new Font("宋体",Font.BOLD,18));
		this.add(password);
		
		but1.setBounds(150, 250, 100, 35);
		but1.setFont(new Font("楷体",Font.BOLD,18));
		this.add(but1);
		
		but2.setBounds(300, 250, 100, 35);
		but2.setFont(new Font("宋体",Font.BOLD,18));
		this.add(but2);
		
		but1.addActionListener(new ActionListener() {  //登陆

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					ClientUI ui = new ClientUI(username.getText()); 
				    Chatmanage.Manager.setUI(ui);
				    dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
		but2.addActionListener(new ActionListener() {  //退出

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}});
	}
}
