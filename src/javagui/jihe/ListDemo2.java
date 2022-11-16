package jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: ���ϵ���
 * @Date: 2022/04/02/21:42
 * ���ֱ�����ʽ������ѧ��
 */
public class ListDemo2 {
    public static void main(String[] args) {
        //�������϶���
        List<Student> list = new ArrayList<>();

        //����ѧ������
        Student s1 = new Student("��",10);
        Student s2 = new Student("���",20);
        Student s3 = new Student("����",30);
        Student s4 = new Student("����",30);

        //��ѧ����ӵ�����
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //���������������еı�����ʽ
        Iterator<Student> it = list.iterator();
        while(it.hasNext()){//��ǰԪ���Ƿ���ֵ
            Student s = it.next();
            System.out.println(s.getName()+","+s.getAge());
        }
        System.out.println("------------------");
        //��ͨfor�����������ı�����ʽ
        for(int i=0;i<list.size();i++){
            Student s = list.get(i);
            System.out.println(s.getName()+","+s.getAge());
        }
        System.out.println("------------------");

        //��ǿfor�ķ�ʽ�����ı�����ʽ
        for (Student s:list){
            System.out.println(s.getName()+","+s.getAge());
        }


    }
}
