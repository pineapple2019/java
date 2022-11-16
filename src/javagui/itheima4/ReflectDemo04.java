package itheima4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
     练习：通过反射实现如下操作
        Student s = new Student();
        s.method1();
        s.method2("林青霞");
        String ss = s.method3("林青霞",30);
        System.out.println(ss);
        s.function();
 */
public class ReflectDemo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<?> c = Class.forName("itheima2.Student");
        //构造一个对象
        Constructor<?> con = c.getConstructor();
        Object obj=con.newInstance();
        //调用方法
        Method m1 = c.getMethod("method1");
        m1.invoke(obj);     //调用无参方法

        //调用有参方法
        Method m2 = c.getMethod("method2", String.class);
        m2.invoke(obj,"林青霞");

        //调用有参方法并且带有返回值
        Method m3 = c.getMethod("method3", String.class, int.class);
        Object o = m3.invoke(obj, "林青霞", 30);
        System.out.println(o);

        //调用私有方法
        Method m4 = c.getDeclaredMethod("function");
        m4.setAccessible(true);
        m4.invoke(obj);
    }
}
