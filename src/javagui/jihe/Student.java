package jihe;

/**
 * @Author: 从南到北
 * @Date: 2022/04/02/13:30
 */
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
}
