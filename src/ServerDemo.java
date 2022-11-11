package Tree.socketheima;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 12/17/2021/15:43
 * @Description:
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        //监听客户端，返回一个套接字
        Socket s = ss.accept();

        //输入流，读数据，并把数据显示到控制台
        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024];
        int len = is.read(bys);
        String data = new String(bys, 0, len);
        System.out.println("服务器收到：" + data);

        ss.close();
    }
}
