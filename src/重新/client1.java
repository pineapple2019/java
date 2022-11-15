package 重新;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    客户端：发送数据，接收服务器反馈
 */

public class client1 {
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket对象(Socket)
        Socket s = new Socket("127.0.0.1", 12345);

        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        //收到数据
        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024];
        int len = is.read(bys);

        String data = new String(bys, 0, len);

        System.out.println("客户端：" + data);

        // 客户端验证代码
        s.shutdownOutput(); //暂时关闭输出流
//        System.out.println("客户端的isInputShutdown():"+s.isInputShutdown());
        System.out.println("客户端s.isOutputShutdown():"+s.isOutputShutdown());
//        System.out.println("客户端.isBound():"+s.isBound());
        System.out.println("客户端s.isConnected():"+s.isConnected());
        System.out.println("客户端isClosed():"+s.isClosed());
        s.close();
    }
}