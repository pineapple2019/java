package com.socket; 
  
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
  
public class SocketClient { 
    public static void main(String[] args) { 
        try { 
            /** 创建Socket*/
            // 创建一个流套接字并将其连接到指定 IP 地址的指定端口号(本处是本机) 
            Socket socket = new Socket("127.0.0.1", 2013); 
            // 60s超时 
            socket.setSoTimeout(60000); 
  
            /** 发送客户端准备传输的信息 */
            // 由Socket对象得到输出流，并构造PrintWriter对象 
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true); 
            // 将输入读入的字符串输出到Server 
            BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in)); 
            printWriter.println(sysBuff.readLine()); 
            // 刷新输出流，使Server马上收到该字符串 
            printWriter.flush(); 
  
            /** 用于获取服务端传输来的信息 */
			
            // 由Socket对象得到输入流，并构造相应的BufferedReader对象 
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
           
		   // 输入读入一字符串 
            String result = bufferedReader.readLine(); 
            System.out.println("Server say : " + result); 
  
            /** 关闭Socket*/
			
            printWriter.close(); 
            bufferedReader.close(); 
            socket.close(); 
        } catch (Exception e) { 
            System.out.println("Exception:" + e); 
        } 
    } 
}


//读数据，read，，，从硬盘读到程序，getInputStream
//写数据，write，，，从程序到硬盘，getOutputStream


//---------------------
//服务器端
package com.socket; 
  
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
  
public class SocketServer { 
    public static void main(String[] args) { 
        try { 
            /** 创建ServerSocket*/
            // 创建一个ServerSocket在端口2013监听客户请求 
            ServerSocket serverSocket = new ServerSocket(2013); 
            while (true) { 
                // 侦听并接受到此Socket的连接,请求到来则产生一个Socket对象，并继续执行 
                Socket socket = serverSocket.accept(); 
  
                /** 获取客户端传来的信息 */
                // 由Socket对象得到输入流，并构造相应的BufferedReader对象 
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                // 获取从客户端读入的字符串 
                String result = bufferedReader.readLine(); 
                System.out.println("Client say : " + result); 
  
                /** 发送服务端准备传输的 */
                // 由Socket对象得到输出流，并构造PrintWriter对象 
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream()); 
                printWriter.print("hello Client, I am Server!"); 
                printWriter.flush(); 
  
                /** 关闭Socket*/
                printWriter.close(); 
                bufferedReader.close(); 
                socket.close(); 
            } 
        } catch (Exception e) { 
            System.out.println("Exception:" + e); 
        }finally{ 
//          serverSocket.close(); 
        } 
    } 
}


--------------
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34	package com.socket; 
  
import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
  
public class SocketClient { 
    public static void main(String[] args) { 
        try { 
            Socket socket = new Socket("127.0.0.1", 2013); 
            socket.setSoTimeout(60000); 
  
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true); 
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
              
            String result = ""; 
            while(result.indexOf("bye") == -1){ 
                BufferedReader sysBuff = new BufferedReader(new InputStreamReader(System.in)); 
                printWriter.println(sysBuff.readLine()); 
                printWriter.flush(); 
                  
                result = bufferedReader.readLine(); 
                System.out.println("Server say : " + result); 
            } 
  
            printWriter.close(); 
            bufferedReader.close(); 
            socket.close(); 
        } catch (Exception e) { 
            System.out.println("Exception:" + e); 
        } 
    } 
}

--------
服务器端
package com.socket; 
  
import java.io.*; 
import java.net.*; 
  
public class Server extends ServerSocket { 
    private static final int SERVER_PORT = 2013; 
  
    public Server() throws IOException { 
        super(SERVER_PORT); 
  
        try { 
            while (true) { 
                Socket socket = accept(); 
                new CreateServerThread(socket);//当有请求时，启一个线程处理 
            } 
        } catch (IOException e) { 
        } finally { 
            close(); 
        } 
    } 
  
    //线程类 
    class CreateServerThread extends Thread { 
        private Socket client; 
        private BufferedReader bufferedReader; 
        private PrintWriter printWriter; 
  
        public CreateServerThread(Socket s) throws IOException { 
            client = s; 
  
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream())); 
              
            printWriter = new PrintWriter(client.getOutputStream(), true); 
            System.out.println("Client(" + getName() + ") come in..."); 
              
            start(); 
        } 
  
        public void run() { 
            try { 
                String line = bufferedReader.readLine(); 
  
                while (!line.equals("bye")) { 
                    printWriter.println("continue, Client(" + getName() + ")!"); 
                    line = bufferedReader.readLine(); 
                    System.out.println("Client(" + getName() + ") say: " + line); 
                } 
                printWriter.println("bye, Client(" + getName() + ")!"); 
                  
                System.out.println("Client(" + getName() + ") exit!"); 
                printWriter.close(); 
                bufferedReader.close(); 
                client.close(); 
            } catch (IOException e) { 
            } 
        } 
    } 
  
    public static void main(String[] args) throws IOException { 
        new Server(); 
    } 
}


