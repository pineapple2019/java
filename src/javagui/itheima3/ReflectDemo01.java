package itheima3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    反射获取构造方法并使用
 */
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName("itheima2.Student");//首先得到字节码文件对象c
        Constructor<?>[] cons = c.getDeclaredConstructors();
        for(Constructor con:cons){
            System.out.println(con);
        }
        System.out.println("----------");
        Constructor<?> con = c.getConstructor();  //通过c得到单个字节码文件对象con，
        Object obj=con.newInstance();   //通过构造方法对象，调用newInstance（），来创建了一个对象
        System.out.println(obj);
        //Student s=new Student();
        //sout（s）
        //上面这种创建对象方式和注释中创建对象方式是一样的，

    }
}
