package itheima4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

//在integer集合中添加string类型的字符串
public class ReflectDemo05 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建集合
        ArrayList<Integer> array = new ArrayList<>();
//        array.add(10);
//        array.add("hello");这个会报错，因为泛型是integer类型的

        Class<? extends ArrayList> c = array.getClass();//获取class对象
        Method m = c.getMethod("add", Object.class);
        m.invoke(array, "hello");
        m.invoke(array,"world");
        m.invoke(array,"java");

        System.out.println(array);
        //反射可以越过泛型检查的，获取到原始的方法所需要的参数类型，最后我们调用原始的方法的参数类型，就可以传字符串了

    }
}
