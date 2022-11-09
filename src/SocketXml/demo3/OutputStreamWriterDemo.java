package demo3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 12/20/2021/15:09
 * @Description:
 */

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        //字符流写数据不能直接写进文件中，会先放到缓存区中，最终需要通过字节流写，需要用flush()刷新流

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("SocketXml\\src\\student.owl"));

        osw.write(97);  //写一个字符
        osw.flush();       //刷新流
        osw.write(98);
        osw.flush();
        osw.write(99);

        osw.write("\n字符流，输出流，写数据\n");

        osw.write("字符流，输出流，写数据");

        osw.close();
    }
}
