package com.wkcto.threadmehtod.p8daemon;

/**
 * Author : 蛙课网老崔
 */
public class SubDaemonThread extends Thread {
    @Override
    public void run() {
        super.run();
        int i=1;
        while(true){
            System.out.println("sub thread....."+i);
            i++;
        }
    }
}

