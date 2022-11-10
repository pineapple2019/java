package bag;

public class Escape {
    public static void main(String[] args) {
        System.out.println(ReturnTest());
        NextTest();
    }
    public static int ReturnTest(){
        int sum=0;
        for(int num=1;num<=10;num++){
            sum=sum+num;
            if(sum>20){
                System.out.println("跳出循环所在的方法");
                return sum=100;//作用：直接结束该函数，返回100;
            }
            System.out.println(sum);
        }
        System.out.println("结束："+sum);
        return 10;
    }
    public static void NextTest(){
        System.out.println("已结束上面方法");
    }
}