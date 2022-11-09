package 酒店管理;

public class Cooker extends Employee implements VIP{
    @Override
    public void serviceVIP() {
        System.out.println("厨师给顾客加菜");
    }
    @Override
    void work() {
        System.out.println("厨师是做饭的");
    }
}
