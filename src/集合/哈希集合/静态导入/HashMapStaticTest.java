package 集合.哈希集合.静态导入;

import 常用工具类.Student;

import java.util.HashMap;
//静态导入的格式，导入
import static java.util.Map.Entry;
import java.util.Set;

public class HashMapStaticTest {
    public static void main(String[] args) {
        //1,创建hashmap集合对象
        HashMap<Student, String> map = new HashMap<>();
        //2，添加元素
        map.put(new Student("lisa",28),"地址1");
        map.put(new Student("tom",27),"北京");
        map.put(new Student("jarry",24),"天津");
        map.put(new Student("jack",23),"河南");

        //取出元素，以键值对的形式
        //首先获取map键值对
        Set<Entry<Student, String>> entries = map.entrySet();
        //然后可以用增强for循环，遍历用键值对填满的set集合
        for(Entry<Student, String> a : entries){
            Student key = a.getKey();
            String value = a.getValue();

            System.out.println(key.toString()+"  "+value);
        }
    }
}
