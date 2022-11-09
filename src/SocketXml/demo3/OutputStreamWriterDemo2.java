package demo3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo2 {
    public static void main(String[] args) throws IOException {
        //字符流写数据不能直接写进文件中，会先放到缓存区中，最终需要通过字节流写，需要用flush()刷新流
        //OutputStreamWriter(OutputStream out)：创建一个使用默认字符编码的OutputStreamWriter
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("SocketXml\\src\\student.owl"));

        //方法二：void write(char[] cbuf)：写入一个字符数组
        char[] chs = {'a', 'b', 'c', 'd', 'e'};
//        osw.write(chs);

        //方法三：void write(char[] cbuf, int off, int len)：写入字符数组的一部分
//        osw.write(chs, 0, chs.length);
//        osw.write(chs, 1, 3);

        //方法四：void write(String str)：写一个字符串
//        osw.write("abcde");

        //方法五：void write(String str, int off, int len)：写一个字符串的一部分
//        osw.write("abcde", 0, "abcde".length());
        osw.write("abcde", 1, 3);

        //释放资源
        osw.close();
        //Exception in thread "main" java.io.IOException: Stream closed
//        osw.write(100);
    }
}
