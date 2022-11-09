package 内部类;


import org.junit.Test;

public class Party {//外部类，聚会
    public void puffBall(){// 吹气球方法
        class Ball {// 内部类，气球
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

