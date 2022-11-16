package itheima4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//反射获取成员变量
public class ReflectDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<?> c = Class.forName("itheima2.Student");
        Field[] fields = c.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("----------");
        Field addressField = c.getField("address");
        Constructor<?> con=c.getConstructor();
        Object obj=con.newInstance();
        addressField.set(obj,"西安");
        System.out.println(obj);
    }
}
