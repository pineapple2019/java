package 文件类操作;/*
    构造方法：
        InputStreamReader(InputStream in)：创建一个使用默认字符集的InputStreamReader
    读数据的2种方式：
        int read()：一次读一个字符数据
        int read(char[] cbuf)：一次读一个字符数组数据
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws IOException {
        FileInputStream isr = new FileInputStream("D:\\fos.txt");
//      第一种方式：

        int ch;
        while((ch=isr.read())!=-1){
            System.out.println(ch);
            System.out.println(Integer.toString(ch));
            System.out.println((char)ch);
        }
        isr.close();

        //第二种方式：
        // int read(char[] cbuf)：一次读一个字符数组数据
//        char[] chs=new char[1];
//        byte[] chs=new byte[100];
//        int len;
//        while((len =isr.read(chs))!=-1){
//            System.out.println(new String(chs,0,len));
////            System.out.println((char)chs);
////        }
//        isr.close();
    }
}



