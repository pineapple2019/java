package jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/02/13:06
 */
public class ListDemo1 {
    public static void main(String[] args) {
        //list��һ���ӿڣ�arrayList��һ���ӿڵ�ʵ����
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");
        System.out.println( list.set(3,"niu"));
        System.out.println("������϶���"+list);
//        System.out.println(list);
//        //��������ʽ��������
//        //���ַ�ʽ�õ��Ľ�����Ǻͱ�������һ��
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
