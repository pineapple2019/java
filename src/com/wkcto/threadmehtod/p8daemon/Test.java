package com.wkcto.threadmehtod.p8daemon;

public class Test {
    public static void main(String[] args) {
        SubDaemonThread thread = new SubDaemonThread();
        //设置线程为守护线程
        //设置守护线程的代码应该在线程启动前
        thread.setDaemon(true);
        thread.start();
        //当前线程为 main 线程
        for(int i = 1; i <= 10 ; i++){
            System.out.println("main== " + i);
        }
        //当 main 线程结束, 守护线程 thread 也销毁了
    }
}

