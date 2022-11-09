package 文件类操作;

import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String s="abc"; //[97, 98, 99]
        String s1="中国";
        //转为字节数组
        byte[] bys=s.getBytes();

        byte[] bys1=s1.getBytes("UTF-8");   //[-28, -72, -83, -27, -101, -67]   此时编译器会将3个字符组成一个汉字
        byte[] bys2=s1.getBytes("GBK");     //[-42, -48, -71, -6]               此时编译器会将2个字符组成一个汉字

        System.out.println(Arrays.toString(bys1));
        System.out.println(Arrays.toString(bys2));
    }
}