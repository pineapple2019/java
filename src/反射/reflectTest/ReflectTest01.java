package reflectTest;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/*
    练习1：我有一个ArrayList<Integer>集合，现在我想在这个集合中添加一个字符串数据，如何实现？
 */
public class ReflectTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建集合
        ArrayList<Integer> array = new ArrayList<>();

        array.add(10);
        array.add(20);
//        array.add("hello");

        Class<? extends ArrayList> c = array.getClass();

        Method m = c.getMethod("add", Object.class);//因为这个方法的参数是object类型的

        m.invoke(array,"hello");
        m.invoke(array,"world");
        m.invoke(array,"java");

        System.out.println(array);
    }
}
