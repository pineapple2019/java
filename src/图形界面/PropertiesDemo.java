package 图形界面;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args)throws IOException {
        function_2();
    }
    /*
     * Properties集合的特有方法store
     * store(OutputStream out)
     * store(Writer w)
     * 接收所有的字节或者字符的输出流,将集合中的键值对,写回文件中保存
     */
    public static void function_2()throws IOException {
        Properties pro = new Properties();
        pro.setProperty("name", "zhangsan");
        pro.setProperty("age", "31");
        pro.setProperty("email", "123456789@163.com");
        FileWriter fw = new FileWriter("D:\\pro.properties");
        //键值对,存回文件,使用集合的方法store传递字符输出流
        pro.store(fw, "666");
        fw.close();
    }
}