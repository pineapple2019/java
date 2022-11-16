package jihe;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/02/14:39
 *  https://www.bilibili.com/video/BV1pA411u7HD
 *  https://www.bilibili.com/video/BV1UB4y1w75J
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        //�������϶���
        ArrayList<String> list = new ArrayList<>();
        //���Ԫ��
        list.add("hello");
        list.add("world");
        list.add("java");

        //�������ϣ�ͨ��list��listIterator���������õ�
        ListIterator<String> lit = list.listIterator(); //��������������Ĭ��ָ��ǰ���ϵ�0����

        while(lit.hasNext()){   //�жϵ�ǰλ���Ƿ���Ԫ�ؿ��Ա�ȡ��
            String s = lit.next();  //��ȡ��ǰλ�õ�Ԫ�أ�������������������һ������λ��
            System.out.println(s);
        }

        //������ͺܺã��������д��Ҳ�ܺ�
//        System.out.println(lit.next());
    }
}
