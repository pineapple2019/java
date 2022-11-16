package jiheset;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 从南到北
 * @Date: 04/06/2022/20:13
 * @Description:
 */
//public class Student implements Comparable<Student>{
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


//    @Override
//    public int compareTo(Student o) {
//        return 0;
//    }
}
