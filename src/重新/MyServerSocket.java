package 重新;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * socket实现聊天
 * 1.创建一个服务器端socket套接字（套接字会在制定的端口上监听）；
 * 2.当有使用ServerSocket中的accept()获取客户端socket对象
 * 3.使用多线程实现聊天：1.MyClientThread线程负责接收客户端发送给服务器端的消息；
 *                      2.MyServerThread线程负责向客户端发送消息
 */
class MyServerSocket{

    public static void main(String[] args) {
        ServerSocket serverSocket = null;//服务器端socket
        Socket clientSocket = null;//客户端socket

        try {
            //创建一个服务器端socket服务
            serverSocket = new ServerSocket(8888);
            while (true) {//使用while死循环模拟客户端一直启动
                clientSocket = serverSocket.accept();//获取连接服务端的客户端socket
                //该线程用于接收客户端发送的消息，并将该消息打印到控制台
                MyClientThread myClientThread = new MyClientThread(clientSocket);
                //该线程用于向客户端发送的消息
                MyServerThread myServerThread = new MyServerThread(clientSocket);

                //启动线程
                myClientThread.start();
                myServerThread.start();
            }
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }//main--end
}//MyServerSocket--end

/**
 * 接收客户端的内容
 * 1.根据客户端Socket获取指向客户端Socket对象的输入流对象（输入源）
 * 2.通过输入流对象将客户端输入的信息读取到内存中
 * 3.通过输出流对象（System.out.print)将内存中的数据打印到控制台
 */

class MyClientThread extends Thread {
    private DataInputStream dataInputStream = null;

    public MyClientThread(Socket socket) {
        try {
            //获取客户端的输入流对象
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException io) {
            io.printStackTrace();
        }
    }//MyClientThread--end
    @Override
    public void run() {
        String tellClient = null;
        try {
            while (true) {
                tellClient = this.dataInputStream.readUTF();//将客户端发送的信息写入到内存中
                System.out.println("客户端说："+tellClient);//将读取的客户端信息打印到控制台
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }//run--end
}//MyClientThread--end

/**
 * 向发送客户端的消息
 * 1.根据客户端Socket获取指向客户端Socket对象的输出流对象（输出目的地）
 * 2.获取控制台输入流对象（输入源）
 * 3.通过输入流对象将控制台输入的信息读取到内存中
 * 4.通过输出流对象将内存中的数据返回给服务器端
 */
class MyServerThread extends Thread {

    private DataOutputStream dataOutputStream = null;//用于输出服务器返回给客户端的信息
    private Scanner in = null;//用于将服务器端在控制台输入的信息读取到内存中

    public MyServerThread(Socket socket) {
        try {
            //根据客户端获取输出流对象
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //获取控制台输入流对象
            in = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//MyServerThread--end

    @Override
    public void run() {
        String tellServer = null;

        while (true) {
            try {
                //将控制台中的信息读入到内存中
                tellServer = in.nextLine();
                //服务器端向客户端发送消息
                this.dataOutputStream.writeUTF(tellServer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//run
}//server
