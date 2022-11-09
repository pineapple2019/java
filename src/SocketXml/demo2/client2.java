package demo2;

import java.io.*;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",12344);
        //获取输入的数据，键盘录入，我们自己来包装
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        s.close();
      }
   }

