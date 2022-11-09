package 集合;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("a");
        objects.add("b");
        objects.add("c");
        objects.add("d");
        Iterator<String> it = objects.iterator();
        //接口实现类对象,调用方法hasNext()判断集合中是否有元素
        boolean b = it.hasNext();
        System.out.println(b);
        //接口的实现类对象,调用方法next()取出集合中的元素
        String s = it.next();
        System.out.println(s+",,,");
        System.out.println("------");
        Iterator<String> it1 = objects.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }
    }
}


