package reflectTest;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 练习2，使用配置文件运行类中的方法
 */
public class ReflectTest02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Student s = new Student();
//        s.study();

        //加载数据
        Properties prop = new Properties();
        FileReader fr = new FileReader("reflectDemo\\class.txt");
//        FileReader fr = new FileReader("C:\\Users\\pineapple\\Desktop\\inbox\\workspace\\AcleanUptheCode\\java基础\\reflectDemo\\class.txt");
        prop.load(fr);

        fr.close();  //为什么这么早就关闭，文件管理这块还是得学啊

        /**
         * className = reflectTest/Student
         * methodName = study
         */

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");




        //通过反射来使用方法
        Class<?> c = Class.forName(className);  // reflectTest/Student
        //通过无参构造方法创建一个对象
        Constructor<?> con = c.getConstructor();
        //实例化
        Object obj = con.newInstance();

        //获取对象（类）方法
        Method m = c.getMethod(methodName); //study
        //调用方法
        m.invoke(obj);
    }
}

