package jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/13:06
 */
public class ListDemo1 {
    public static void main(String[] args) {
        //list是一个接口，arrayList是一个接口的实现类
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");
        System.out.println( list.set(3,"niu"));
        System.out.println("输出集合对象："+list);
//        System.out.println(list);
//        //迭代器方式遍历集合
//        //这种方式得到的结果，是和遍历数组一样
//        Iterator<String> it = list.iterator();
//
//        while(it.hasNext()){
//            String s = it.next();
//            System.out.println(s+",");
//        }
////        while( list.iterator().hasNext()){
////            String s =  list.iterator().next();
////            System.out.println(s+",");
////        }
    }
}
