package 常用工具类;

public class Person {
    int age;
    String name;
    public Person(){

    }
    public Person(int age,String name){
        this.age = age;
        this.name = name;
    }
    public void speak(){
        System.out.println("人会说话");
    }

    //判断是否为同龄人
    public static void  equalPerson(Person a,Person b){
        if(a.age==b.age){
            System.out.println("是同龄人");
        }else{
            System.out.println("不是同龄人");
        }
    }
    public void equalPerson1(Person a){
        if(this.age == a.age){
            System.out.println("是同龄人");
        }else{
            System.out.println("不是同龄人");
        }

    }


    public static void main(String[] args) {
        Person a = new Person(1, "小明");
        Person b = new Person(2, "小红");
        equalPerson(a,b);
        a.equalPerson1(b);


    }
}
