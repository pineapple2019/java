package 内部类;

import org.junit.Test;
//外部类，聚会
public class Party {
    // 吹气球方法
    public void puffBall(){
        String a ="吹气球方法里面的局部变量";

        // 内部类，气球，这是个局部内部类，因为位置是和局部变量一样的
        class Ball {
            public void puff(){

                System.out.println("气球膨胀了");
            }
        }
        //创建内部类对象，调用puff方法
        new Ball().puff();
    }
    
    //我认为test的作用就是为了可以省略掉main函数的书写
    @Test
    public void test1(){
        Party party = new Party();
        party.puffBall();
    }

}

