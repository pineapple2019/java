package 图形界面;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 12/17/2021/15:35
 * @Description:
 * 客户端：发送数据，接收服务器反馈
服务器：接收数据，给出反馈
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        Socket s = new Socket("localhost", 12345);
        //获取输出流，写数据
        OutputStream os = s.getOutputStream();
//        os.write("你好，hello,server".getBytes(StandardCharsets.UTF_8));
        os.write("你好，hello,server".getBytes());
        s.close();
    }
}
