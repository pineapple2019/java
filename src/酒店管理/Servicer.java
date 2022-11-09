package 酒店管理;

public class Servicer extends Employee implements VIP{
    Servicer(){
        super();
    }
    Servicer(String name,int nums){
        super(name,nums);
    }

    @Override
    public void serviceVIP() {
        System.out.println("服务员给顾客倒酒");
    }
    @Override
    void work() {
        System.out.println("服务员是端菜倒酒的");
    }
}


