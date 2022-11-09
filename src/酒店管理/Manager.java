package 酒店管理;

public class Manager extends Employee{
    //奖金
    int bouns;

    @Override
    void work() {
        System.out.println("大堂经理是门面");
    }
}
