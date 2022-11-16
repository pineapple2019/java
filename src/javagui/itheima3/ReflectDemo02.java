package itheima3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    通过反射实现如下的操作：
        Student s = new Student("林青霞",30,"西安");
        System.out.println(s);
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<?> c = Class.forName("itheima2.Student");
        Constructor<?> con = c.getConstructor(String.class, int.class, String.class);
        Object obj = con.newInstance("林青霞", 30, "西安");
        System.out.println(obj);
    }
}
