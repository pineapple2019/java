package itheima1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo {
    public static void main(String[] args) {

        //创建集合对象
//        Collection c=new ArrayList();
        Collection<String> c=new ArrayList<String>();

        //添加元素，当我们没有指定添加类型的时候，添加的是默认object类型，因为泛型默认是引用类型，object可以代表所有的引用类型

        c.add("hello");
        c.add("world");
        c.add("java");      //我们把字符串赋值给object是向上转型
       // c.add(100);       这里会报错，因为前面已经用了String泛型，所以，100是一个int类型，会报错，就将运行期间的错误提前到编译阶段

        //使用迭代器来进行遍历

        Iterator<String> it = c.iterator();
        while(it.hasNext()){
            /**
             *    Object obj=it.next();   //添加的时候，指针是object类型，所以获取的时候，也是object类型
             *             System.out.println(obj);
             */
            //因为存储的是object类型， 所以我们向下转型，想将其变成string类型，
//            String s=(String) it.next();
            String s=it.next();     //有了泛型，就不用加强制类型转换了

            System.out.println(s);

        }
    }
}
