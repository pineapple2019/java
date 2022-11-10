package bag;

public class sumTest {
    //计算1-50的和
    public static void main(String[] args) {
        System.out.println(calsum(50));
    }
    //确认参数和返回值类型,计算从i到j的和，结果为sum
    public static int calsum(int i){//50
        //终止条件
        if(i==1) {
            return 1;
        }
        //单层逻辑
        return calsum(i-1)+i;
    }
}
