package trans;

/*
    客户端：发送数据，接收服务器反馈
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
     //创建套接字，客户端
     Socket s = new Socket("127.0.0.1",10086);
        //获取输出流，写数据
        OutputStream os=s.getOutputStream();    //向服务器端发数据，原来也算是写数据呀，就是out
        os.write("hello,server".getBytes());    //输出数据
        //接收服务器端的反馈
        InputStream is = s.getInputStream();      //收数据，reader


        byte[] bys= new byte[1024];             //
        int len= is.read(bys);  //一次读取一个字符数组
        String data = new String(bys,0,len);    //从0到len，
        System.out.println("客户端"+data);


        s.close();
    }
}
