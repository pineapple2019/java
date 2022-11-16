package client;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Chatmanage {
	
	public Chatmanage() {};
	public static final Chatmanage Manager=new Chatmanage();
	HashMap<String,StringBuffer> chathistory=new HashMap<String,StringBuffer>();// 记录聊天历史
	ClientUI UI;
	Socket socket;
	String IP;
    InputStream in;
    OutputStream out;
    byte[] buf = new byte[1024];
    
    public void setUI(ClientUI UI) 
    {
    	this.UI=UI;
    	UI.setVisible(true);
    	connect();
    }
	
	public void send(String goal,String myusername,String mag) throws IOException//发送消息
	{
		if(mag.length()!=0)             //不能发空消息
		{
		out.write((goal+":"+myusername+"/"+mag).getBytes());
		}
	}
	
	public void updatelist(String username) throws IOException //更新在线列表
	{
		out.write(("updatelist:"+username+"/").getBytes());
	}
	
	public void exit(String myname) throws IOException
    {
		String inf="Exit:"+myname+"/"+"无消息";
		out.write(inf.getBytes());
	}
	
	public void updateliststatu(String user,String statu)
	{
		DefaultTableModel tbm=(DefaultTableModel)UI.userlist.getModel();//取得在线列表的数据模型
        for(int i=0;i<tbm.getRowCount();i++)
        {
       	   if(tbm.getValueAt(i, 0).equals(user))
       	   {
       		 tbm.setValueAt(statu,i,1);
       		 return;
       	   }
        }
	}
	
	public void connect() {
		new Thread() {
			public void run() {
				
				try {
					//IP =new String(InetAddress.getLocalHost().toString());
					  IP="10.1.10.73";
					//socket=new Socket(IP.substring(IP.indexOf("/")+1),10000);
					  socket=new Socket(IP,10000);
					  out=socket.getOutputStream();
					  in=socket.getInputStream();
					 
					 updatelist(UI.username);
					 
					 while (true) {                            //等待接收
	                      
						 int len=in.read(buf);
						 String line=new String(buf,0,len);
						 
						 String head=line.substring(0, line.indexOf(":"));
						 String mid=line.substring(line.indexOf(":")+1,line.indexOf("/"));
						 String last=line.substring(line.indexOf("/")+1);
						 
						 if(head.equals("群聊天室"))//如果接收的是群聊
						 {
							 Chatmanage.Manager.chathistory.get(head).append(mid+"：\n"+last+"\n\n");
							 if(UI.goal.equals(head))//如果当前窗口
							 {
								 UI.chatarea.setText(Chatmanage.Manager.chathistory.get(head).toString());
								 UI.chatarea.setCaretPosition(UI.chatarea.getDocument().getLength());  
							 }
							 else                   //不是当前窗口
							 {
								 updateliststatu(head,"待收");
							 }
						 }
						 else if(head.equals("updatelist")) //更新在线者列表
						 { 
							    String[] content=mid.split(",");
							    
			                    DefaultTableModel tbm = (DefaultTableModel) UI.userlist.getModel();//提取在线列表的数据模型
			                    tbm.setRowCount(0);
			                    for(String username:content) 
			                    {
			                    	String[] tmp=new String[2];
			                    	tmp[0]=username;
			                    	tmp[1]="无";
			                    	tbm.addRow(tmp);
			                    	if(!chathistory.containsKey(username))     //添加聊天记录键值对
			                    	{
			                    		StringBuffer bufferstart=new StringBuffer("");
			                    		chathistory.put(username, bufferstart);
			                    	}
			                    }   
			                    DefaultTableCellRenderer tbr = new DefaultTableCellRenderer();//提取在线列表的渲染模型
			                    tbr.setHorizontalAlignment(JLabel.CENTER);  //表格数据居中显示
			                    UI.userlist.setDefaultRenderer(Object.class, tbr);
						 }
						 else  //个人聊天室
						 {  
							 if(UI.username.equals(mid))   //如果发送者是自己
							 {
								 Chatmanage.Manager.chathistory.get(head).append(mid+"：\n"+last+"\n\n");
								 if(UI.goal.equals(head))
								 {
									 UI.chatarea.setText(Chatmanage.Manager.chathistory.get(head).toString());
									 UI.chatarea.setCaretPosition(UI.chatarea.getDocument().getLength());
								 }
							 }
							 else                          //如果是别人私聊自己
							 {
							    Chatmanage.Manager.chathistory.get(mid).append(mid+"：\n"+last+"\n\n");
							    if(UI.goal.equals(mid))
							    {
								    UI.chatarea.setText(Chatmanage.Manager.chathistory.get(mid).toString());
								    UI.chatarea.setCaretPosition(UI.chatarea.getDocument().getLength());
							    }
							    else
							    {
							    	updateliststatu(mid,"待收");
							    }
							 }
	                    }
					 }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					UI.chatarea.append("服务器挂了，稍安勿躁.....");
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	
}
