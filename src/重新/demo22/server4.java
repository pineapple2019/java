package demo22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 12/20/2021/17:47
 * @Description:客户端数据来自文本，服务器数据写入文本
 */
public class server4 {
        public static void main(String[] args) throws IOException {
            //创建服务器Socket对象
            ServerSocket ss = new ServerSocket(12343);
            //监听客户端的连接，返回一个对应的Socket对象
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SocketXml\\src\\test.owl")));
            String line;
            //将读到的数据写入到文件中
            while ((line = br.readLine()) != null) {
//            System.out.println(line);
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
            bw.close();
            //释放资源
            ss.close();
        }
    }

