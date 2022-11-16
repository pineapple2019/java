package itheima4;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*
    练习2：通过配置文件运行类中的方法
 */
public class ReflectDemo06 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //加载数据
        Properties prop = new Properties();
        FileReader fr=new FileReader("swingDemo\\src\\class.txt");
        prop.load(fr);
        fr.close();

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //通过反射来使用
        Class<?> c=Class.forName(className);
        Constructor<?> con=c.getConstructor();
        Object obj=con.newInstance();

        Method m=c.getMethod(methodName);
        m.invoke(obj);
    }
}
