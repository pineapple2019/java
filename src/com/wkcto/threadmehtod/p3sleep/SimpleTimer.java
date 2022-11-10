package com.wkcto.threadmehtod.p3sleep;
/**
 * 使用线程休眠 Thread.sleep 完成一个简易的计时器
 * @author pineapple
 */
public class SimpleTimer {
    public static void main(String[] args) {
        //从 60 秒开始计时(默认)
        int remaining = 60;
        //读取 main 方法的参数
        if (args.length == 1){
            remaining = Integer.parseInt(args[0]);
        }
        while(true){
            System.out.println(Thread.currentThread().getName()+",Remaining: " + remaining);
            remaining--;
            if (remaining < 0 ){
                break;
            }
            try {
                //线程休眠
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done!!");
    }
}


