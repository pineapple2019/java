package Socket6;

import java.io.*;
import java.net.Socket;
/*

黑马练习6，修改版，用于实现资源注册，目前难点，是可以多用户进行实现，但是如何多用户对一个文本修改，其修改内容应该是在上一个用户修改的内容上添加
而不是重写，这个可以用到append，
这个append好像是在那个里面，就是我之前练习的那个黑马聊天室。
任务，练习黑马聊天室，还有就是这个练习6
服务器好好的 ，就是要为每一个客户端开启一个线程。
 */

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //创建客户端Socket对象
        Socket s = new Socket("localhost",10003);

        //封装文本文件的数据
//        BufferedReader br = new BufferedReader(new FileReader("SocketXml\\src\\student.owl"));
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

        //封装输出流写数据
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line;
        while ((line=BR.readLine())!=null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        s.shutdownOutput();

        //接收反馈
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String data = brClient.readLine(); //等待读取数据
        System.out.println("服务器的反馈：" + data);

        //释放资源
        BR.close();
        s.close();
    }
}
