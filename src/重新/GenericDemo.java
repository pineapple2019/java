package 重新;

/**
 * @Author: 从南到北
 * @Date: 2022/01/07/13:43
 */


class Teacher {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Generic<T> {
    private T t;
    public T getT(){
        return t;
    }
    public void setT(T t){
        this.t = t;
    }
}
public class GenericDemo {
    public static void main(String[] args) {
        Student s=new Student();
        s.setName("林青霞");
        System.out.println(s.getName());

        Teacher t=new Teacher();
        t.setAge(30);
        System.out.println(t.getAge());

        System.out.println("______________________");

        Generic<String> g1=new Generic<String>();
        g1.setT("林青霞");
        System.out.println(g1.getT());

        Generic<Integer> g2= new Generic<Integer>();
        g2.setT(30);
        System.out.println(g2.getT());

        Generic<Boolean> g3 = new Generic<Boolean>();
        g3.setT(true);
        System.out.println(g3.getT());

    }
}
