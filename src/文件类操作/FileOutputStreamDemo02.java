package 文件类操作;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    构造方法：
        FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
        FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件

    写数据的三种方式：
        void write(int b)：将指定的字节写入此文件输出流
        一次写一个字节数据

        void write(byte[] b)：将 b.length字节从指定的字节数组写入此文件输出流
        一次写一个字节数组数据

        void write(byte[] b, int off, int len)：将 len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流
        一次写一个字节数组的部分数据
*/

public class FileOutputStreamDemo02 {
    public static void main(String[] args) throws IOException {
        //FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
        FileOutputStream fos = new FileOutputStream("D:\\fos.txt");
        //代码一执行，整个文件都是重新建立的
        //new File(name)
//        FileOutputStream fos = new FileOutputStream(new File("myByteStream\\fos.txt"));

        //FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件
//        File file = new File("myByteStream\\fos.txt");
//        FileOutputStream fos2 = new FileOutputStream(file);
//        FileOutputStream fos2 = new FileOutputStream(new File("myByteStream\\fos.txt"));

        //void write(int b)：将指定的字节写入此文件输出流
//        fos.write(97);
//        fos.write(98);
//        fos.write(99);
//        fos.write(100);
//        fos.write(101);

//        void write(byte[] b)：将 b.length字节从指定的字节数组写入此文件输出流
//        byte[] bys = {97, 98, 99, 100, 101};
        //byte[] getBytes()：返回字符串对应的字节数组
        byte[] bys = "abcde".getBytes();
//        fos.write(bys);

        //void write(byte[] b, int off, int len)：将 len字节从指定的字节数组开始，从[偏移量off]开始写入此文件输出流
//        fos.write(bys,0,bys.length);
        fos.write(bys,1,3); //bcd//这个意思是，从索引为1开始，写3个
        //释放资源
        fos.close();
    }
}