package 集合.哈希集合;

import java.util.*;

class MapMapDemo {
    public static void main(String[] args) {
        //定义基础班集合
        HashMap<String, String> javase = new HashMap<String, String>();

        //定义就业班集合
//        HashMap<String, String> javaee = new HashMap<String, String>();
        //向班级集合中,存储学生信息
        javase.put("001", "张三");
        javase.put("002", "李四");
        javase.put("003", "王五");
        javase.put("004", "赵六");
//        javaee.put("001", "王五");
//        javaee.put("002", "赵六");
        //定义传智播客集合容器,键是班级名字,值是两个班级容器
//        HashMap<String, HashMap<String, String>> czbk =
//                new HashMap<String, HashMap<String, String>>();
//        czbk.put("基础班", javase);
//        czbk.put("就业班", javaee);
//        czbk.keySet();

        //遍历方式1,获取所有的键集合
        Set<String> keyset = javase.keySet();
        //通过迭代器方式遍历key，获取值
        Iterator<String> it = keyset.iterator();

        while(it.hasNext()){
            //获取每一个key
            String key = it.next();
            //通过key获取值
            String value = javase.get(key);

            System.out.println(key+"="+value);

        }

        //方式2，通过获取键值对entry，他的实现类是entryset
        Set<Map.Entry<String,String>> objects  = javase.entrySet();

        Iterator<Map.Entry<String, String>> iterator = objects.iterator();

        while(iterator.hasNext()){
            //这是个键值对对象
            Map.Entry<String, String>  a = iterator.next();
            String b = a.getKey();
            String c = a.getValue();
            System.out.println(b+" "+c);
        }

        //转换为set后，就可以使用迭代器了！



    }
}


