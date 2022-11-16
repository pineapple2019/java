package itheima4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
    反射获取成员方法并使用
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
     //获取Class对象
        Class<?> c = Class.forName("itheima2.Student");
        Method[] methods = c.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method);
        }
        System.out.println("-----------");
        Method m =c.getMethod("method1");
        //获取无参构造方法创建对象
        Constructor<?> con=c.getConstructor();
        Object obj=con.newInstance();
        m.invoke(obj);




    }
}
