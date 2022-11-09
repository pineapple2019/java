package demo5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端socket
 * 1.根据IP和port获取和服务端连接的Socket对象
 * 2.通过服务端Socket对象获取指向服务端Socket对象的输入流/输出流，获取服务器端发送的信息或者向服务器发送消息
 */
class MyClientSocket {

    public static void main(String[] args) {
        Socket serverSocket = null;
        try {
            serverSocket = new Socket("127.0.0.1", 8888);

            MyClientToSerThread myClientToSerThread = new MyClientToSerThread(serverSocket);
            MyAcceptServerThread myAcceptServerThread = new MyAcceptServerThread(serverSocket);

            myClientToSerThread.start();
            myAcceptServerThread.start();

        } catch (IOException io) {
            io.printStackTrace();
        }

    }//main--end
}//MyClientSocket--end

/**
 * 向服务端发送消息
 */
class MyClientToSerThread extends Thread {

    private DataOutputStream dataOutputStream = null;
    private Scanner in = null;

    public MyClientToSerThread(Socket socket) {
        try {
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.in = new Scanner(System.in);
        } catch (IOException io) {
            io.printStackTrace();
        }
    }//MyClientToSerThread--end

    @Override
    public void run() {
        String tell = null;
        while (true) {
            try {
                tell = in.nextLine();
                dataOutputStream.writeUTF(tell);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//run--end
}//MyClientToSerThread--end
/**
 *接收客户端的信息
 **/
class MyAcceptServerThread extends Thread {

    private DataInputStream dataInputStream = null;

    public MyAcceptServerThread(Socket socket) {
        try {
            this.dataInputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//MyAcceptServerThread--end

    @Override
    public void run() {
        String tell = null;
        while (true) {
            try {
                tell = this.dataInputStream.readUTF();
                System.out.println("服务端："+tell);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//run--end
}//MyAcceptServerThread--end
