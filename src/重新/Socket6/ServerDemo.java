package Socket6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);

        while(true){
            //监听客户端，返回一个对应的socket对象
            Socket s = ss.accept();
            new Thread(new ServerThread(s)).start();
        }

    }
}
