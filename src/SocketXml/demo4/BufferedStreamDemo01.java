package demo4;

import java.io.*;

public class BufferedStreamDemo01 {
    public static void main(String[] args) throws IOException {
        //BufferedWriter(Writer out)

        //字符缓冲流写数据到txt，输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("SocketXml\\src\\student.owl")));

        bw.write("hello,你好\r\n");
        bw.write("world,世界\r\n");

        bw.close();

    }
}
