package sockethm;

import java.io.*;
public class BufferStreamDemo {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("SocketXml\\src\\student.owl"));

        //一次读取一个字节数据
        int by;
        while ((by=bis.read())!=-1) {
            System.out.print((char)by);//这个！会报错，因为是每次读一个字节，char
        }
        //一次读取一个字节数组
//        byte[] bys = new byte[1024];
//        int len;
//
//        while ((len=bis.read(bys))!=-1) {
//            System.out.print(new String(bys,0,len));
//        }
        bis.close();
    }
}
