package 集合.哈希集合;

import 常用工具类.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        //1，创建hashmap集合对象
        Map<Student,String> map  = new HashMap<>();

        //2，添加元素
        map.put(new Student("lisa",28),"地址1");
        map.put(new Student("tom",27),"北京");
        map.put(new Student("jarry",24),"天津");
        map.put(new Student("jack",23),"河南");

        //取出元素方式1，通过获取键集合，然后遍历键集合，获取值
        Set<Student> keyset = map.keySet();

        //遍历键,并用迭代器的方式
        //集合不能直接用迭代器，或者foreach进行遍历，但是转换为set后就可以。
        Iterator<Student> it = keyset.iterator();

        while(it.hasNext()){
            //获取每一个键
            Student key = it.next();
            //根据键获取值
            String value = map.get(key);
           System.out.println(key.toString()+"...."+value);
        }

        //通过第二种方式，直接获取所有的键值对，然后取出元素
        //entrySet，返回一个set集合，其中的泛型是一个map集合，要标明其键值对的类型
        Set<Map.Entry<Student, String>> entries = map.entrySet();
        //增强for循环，遍历类型为map的set集合
        for(Map.Entry<Student, String> entry:entries){
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key.toString()+" -- "+value);
        }

    }
}
