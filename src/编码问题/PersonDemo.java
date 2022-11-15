package 编码问题;

public class PersonDemo {
    public static void main(String[] args) {
        PingpangCoach p1 = new PingpangCoach();
        p1.setAge(30);
        p1.setName("乒乓教练1");
        System.out.println(p1.getName()+","+p1.getAge());
        p1.teach();
        p1.speak();
        p1.eat();
        PingpangCoach p2 = new PingpangCoach("乒乓教练2",32);
        System.out.println(p2.getName()+","+p2.getAge());
        p2.teach();
        p2.speak();
        p2.eat();
        System.out.println("-----------------");

        PingpangPlayer pp1 = new PingpangPlayer();
        pp1.setName("乒乓运动员1");
        pp1.setAge(20);
        System.out.println(pp1.getName()+","+pp1.getAge());
        pp1.study();
        pp1.speak();
        pp1.eat();

        PingpangPlayer pp2 = new PingpangPlayer("乒乓球运动员2",21);
        pp2.setName("乒乓运动员1");
        pp2.setAge(20);
        System.out.println(pp2.getName()+","+pp2.getAge());
        pp2.study();
        pp2.speak();
        pp2.eat();


    }
}
