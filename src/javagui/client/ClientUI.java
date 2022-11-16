package client;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
public class ClientUI extends JFrame 
{
	    private static final long serialVersionUID = 1L;
		JTextArea chatarea;
	    JTextArea sendarea;
	    JButton send;
	    JButton exit;
	    JTable userlist;
	    String[] columnTitle= {"在线者","待收消息"};
	    String[][] rowdata=null;
	    JScrollPane jscchatarea;
	    JScrollPane jsclist;
	    String username;
	    String goal="群聊天室";
	    
	    public ClientUI() {}
	    
	    public ClientUI(String username) throws IOException
	    {
	    	this.username=username;
	    	this.setDefaultCloseOperation(0);
	    	this.setTitle("聊天室-"+username);
	    	this.setSize(700, 700);
	    	this.setResizable(false);
	    	setLayout(null);
	    	this.getContentPane().setBackground(Color.GRAY);
	    	
	    	chatarea=new JTextArea();
	    	chatarea.setLineWrap(true);
	    	chatarea.setEditable(false);
	    	chatarea.setFont(new Font("楷体",Font.BOLD,16));
	    	
	    	//输入框
	    	sendarea=new JTextArea();
	    	sendarea.setBounds(20, 480, 360, 120);
	    	sendarea.setFont(new Font("楷体",Font.BOLD,18));
	    	this.add(sendarea);
	    	
	    	//发送按钮
	    	send=new JButton("发送");
	    	send.setBounds(320,430 ,60, 40);
	    	send.setFont(new Font("楷体",Font.BOLD,11));
	    	this.add(send);
	    	
	    	//关闭按钮
	    	exit=new JButton("关闭");
	    	exit.setBounds(240,430,60,40);
	    	exit.setFont(new Font("楷体",Font.BOLD,11));
	    	this.add(exit);
	    	//好友列表
	    	
	    	userlist=new JTable(new DefaultTableModel(rowdata,columnTitle) 
	    	{
				private static final long serialVersionUID = 1L;
				public boolean isCellEditable(int row,int column)
	    		{
	    			return false;
	    		}
	    	});
	    	userlist.setFont(new Font("楷体",0,15));
	    	
	    	jscchatarea=new JScrollPane(chatarea);
	    	jscchatarea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    	jscchatarea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    	jscchatarea.setBounds(20, 20, 360, 400);
	    	this.add(jscchatarea);
	    	
	    	jsclist=new JScrollPane(userlist);
	    	jsclist.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    	jsclist.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    	jsclist.setBounds(420, 20, 250, 500);
	    	this.add(jsclist);
	    	
	    	send.addActionListener(new ActionListener(){    //添加提交事件
				@Override
				public void actionPerformed(ActionEvent e){
					// TODO Auto-generated method stub
					try {
						Chatmanage.Manager.send(goal,username,sendarea.getText());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sendarea.setText("");
				}
	    	});
	    	
	    	exit.addActionListener(new ActionListener() {//添加退出事件
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						Chatmanage.Manager.exit(username);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				}
	    	});
	    	
	    	userlist.addMouseListener//添加选中事件
             (
                 new MouseListener()
                 {
                     @Override
                     public void mouseClicked(MouseEvent event)
                     {
                         DefaultTableModel tbm = (DefaultTableModel) userlist.getModel();//取得在线列表的数据模型
                         int row=userlist.getSelectedRow();
                         goal=(String)tbm.getValueAt(row, 0);
                         setTitle(goal+"-"+username);
                         chatarea.setText(Chatmanage.Manager.chathistory.get(goal).toString());
                         chatarea.setCaretPosition(chatarea.getDocument().getLength());
                         tbm.setValueAt("无",row,1);
                     }
                     @Override
                     public void mousePressed(MouseEvent event){};
                     @Override
                     public void mouseReleased(MouseEvent event){};
                     @Override
                     public void mouseEntered(MouseEvent event){};
                     @Override
                     public void mouseExited(MouseEvent event){};
                     
                 }
             );
	    }
}
