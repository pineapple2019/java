package 重新;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
//一次读取一个字节数组

public class server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12345);
        Socket s = ss.accept();
        //接收数据

        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int len = is.read(bys);
        System.out.print("服务器:"+ new String(bys,0,len));
        //发送数据
        OutputStream os = s.getOutputStream();

        // 客户端验证代码
        s.shutdownOutput(); //暂时

        // 关闭输出流
//        System.out.println("服务端的isInputShutdown():"+s.isInputShutdown());
        System.out.println("服务端s.isOutputShutdown():"+s.isOutputShutdown());
        System.out.println("服务端.isBound():"+s.isBound());
        System.out.println("服务端s.isConnected():"+s.isConnected());
        System.out.println("服务端isClosed():"+s.isClosed());

        os.write("服务器反馈".getBytes());

        //关闭套接字
        ss.close();
    }
}
