package sockethm;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 12/17/2021/16:06
 * @Description:
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端的Socket对象(Socket)
        Socket s = new Socket("localhost", 12345);
        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
        os.write("hello,tcp,我来了".getBytes());

        s.close();
    }
}
