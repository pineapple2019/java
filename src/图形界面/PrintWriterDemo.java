package 图形界面;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        function_2();
        function_1();

    }

    /*
     * 打印流,输出目的,是流对象
     * 可以是字节输出流,可以是字符的输出流
     * OutputStream  Writer
     */

    public static void function_2() throws IOException{
        //	FileOutputStream fos = new FileOutputStream("c:\\3.txt");
        FileWriter fw = new FileWriter("d:\\out.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println("打印流");
        pw.close();
    }

    /*
     * 打印流,输出目的,String文件名
     */

    public static void function_1() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("d:\\2.txt");
        pw.println(3.5);
        pw.close();
    }

}