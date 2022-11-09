package Demo;

public class PingpangCoach extends Coach implements SpeakEnglish{

    public PingpangCoach() {
    }
    public PingpangCoach(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("乒乓球教练教乒乓球");
    }
    @Override
    public void eat() {
        System.out.println("乒乓球教练吃肉喝酒");
    }

    @Override
    public void speak() {
        System.out.println("乒乓球教练会说英语");
    }

}
