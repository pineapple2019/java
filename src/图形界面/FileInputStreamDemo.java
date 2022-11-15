package 图形界面;

import java.io.FileInputStream;
import java.io.IOException;

/*

 *  FileInputStream读取文件
 *  读取方法  int read(byte[] b) 读取字节数组
 *  数组作用: 缓冲的作用, 提高效率
 *  read返回的int,表示什么含义 读取到多少个有效的字节数
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\out.txt");
        // 创建字节数组
        byte[] b = new byte[2];
        int len = fis.read(b);
        int len1 = fis.read();
        System.out.println(new String(b));// ab，
        System.out.println(len);// 2
        System.out.println(len1);// 2

//        len = fis.read(b);
//        System.out.println(new String(b));// cd
//        System.out.println(len);// 2
//
//        len = fis.read(b);
//        System.out.println(new String(b));// ed
//        System.out.println(len);// 1
//
//        len = fis.read(b);
//        System.out.println(new String(b));// ed
//        System.out.println(len);// -1

        fis.close();
    }
}