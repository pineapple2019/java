package jiheset;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 04/06/2022/21:15
 * @Description:
 * 存储学生对象并遍历，创建TreeSet集合使用带参构造方法
 * 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序
 */
public class TreeSetDemo1 {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int num =s1.getAge()-s2.getAge();
                int num2 = num ==0?s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });
        //创建学生对象
        Student s1 = new Student("xishi",29);
        Student s2 = new Student("diaochan",30);
        Student s3 = new Student("baiqi",28);
        Student s4 = new Student("lixin",33);

        //学生添加到集合中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);

        //遍历
        for (Student s:ts) {
            System.out.println(s.getName()+","+s.getAge());
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.remove();

    }
}
