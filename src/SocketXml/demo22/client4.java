package demo22;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 12/20/2021/17:48
 * @Description:
 */
public class client4 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",12343);
        //获取输入的数据，键盘录入，我们自己来包装
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("SocketXml\\src\\student.owl")));





        //发送数据,有了这个，就可以写数据了
//        字节输出流转换成字符输出流转，然后再包装成字符缓冲流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line;
        while ((line=br.readLine())!=null) {
            if ("886".equals(line)) {
                break;
            }
            bw.write(line); //写一行
            bw.newLine();   //换行
            bw.flush(); //刷新
        }
        br.close();
        s.close();
    }
}
