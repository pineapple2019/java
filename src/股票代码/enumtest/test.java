package enumtest;

public class test {

    public void test(SeasonEnum s){
        switch(s)
        {
            case SPRING:
                System.out.println("春天到了");
                break;
            case SUMMER:
                System.out.println("夏天到了");
                break;
            case FALL:
                System.out.println("秋天到了");
                break;
            default:
                System.out.println("冬天到了");
        }
    }

    public static void main(String[] args) {
        for(SeasonEnum s : SeasonEnum.values()){
            System.out.println(s);
        }
    }




}
