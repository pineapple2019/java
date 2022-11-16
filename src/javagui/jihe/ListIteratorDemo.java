package jihe;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/14:39
 *  https://www.bilibili.com/video/BV1pA411u7HD
 *  https://www.bilibili.com/video/BV1UB4y1w75J
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("hello");
        list.add("world");
        list.add("java");

        //遍历集合，通过list的listIterator（）方法得到
        ListIterator<String> lit = list.listIterator(); //创建迭代器对象，默认指向当前集合的0索引

        while(lit.hasNext()){   //判断当前位置是否有元素可以被取出
            String s = lit.next();  //获取当前位置的元素，将迭代器对象移向下一个索引位置
            System.out.println(s);
        }

        //这个解释很好，这个代码写的也很好
//        System.out.println(lit.next());
    }
}
