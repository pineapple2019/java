package reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
    反射获取成员变量并使用
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class<?> c = Class.forName("com.itheima_02.Student"); //拿到这个类

        //Field[] getFields() 返回一个包含 Field对象的数组， Field对象反映由该 Class对象表示的类或接口的所有可访问的公共字段
        //Field[] getDeclaredFields() 返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段


//        Field[] fields = c.getFields();     //返回所有公共成员变量
//        Field[] fields = c.getDeclaredFields();
//        for(Field field : fields) {
//            System.out.println(field);
//        }
//        System.out.println("--------");

        //Field getField(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定公共成员字段
        //Field getDeclaredField(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定声明字段
        Field addressField = c.getField("name");
//      System.out.println(addressField);
//        //获取无参构造方法创建对象
        Constructor<?> con = c.getConstructor();  //这两步等同于这一步Student s = new Student();，获取对象的构造方法
        Object obj = con.newInstance();

        //Field提供有关类或接口的单个字段的信息和动态访问
        //void set(Object obj, Object value) 将指定的对象参数中由此 Field对象表示的字段设置为指定的新值
        addressField.set(obj,"西安"); //给obj的成员变量addressField赋值为西安    //等同于这一步obj.setaddressField = "西安";
        System.out.println(obj);

//        Student s = new Student();
//        s.address = "西安";
//        System.out.println(s);
    }
}