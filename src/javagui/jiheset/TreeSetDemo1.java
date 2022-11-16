package jiheset;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: ���ϵ���
 * @Date: 04/06/2022/21:15
 * @Description:
 * �洢ѧ�����󲢱���������TreeSet����ʹ�ô��ι��췽��
 * Ҫ�󣺰��������С��������������ͬʱ��������������ĸ˳������
 */
public class TreeSetDemo1 {
    public static void main(String[] args) {
        //�������϶���
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num =s1.getAge()-s2.getAge();
                int num2 = num ==0?s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });
        //����ѧ������
        Student s1 = new Student("xishi",29);
        Student s2 = new Student("diaochan",30);
        Student s3 = new Student("baiqi",28);
        Student s4 = new Student("lixin",33);

        //ѧ����ӵ�������
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);

        //����
        for (Student s:ts) {
            System.out.println(s.getName()+","+s.getAge());
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.remove();

    }
}
