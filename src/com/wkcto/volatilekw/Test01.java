package com.wkcto.volatilekw;

/**
 * @author pineapple
 */
public class Test01 {
    public static void main(String[] args) {
        //创建PrintString对象
        PrintString printString = new PrintString();
        //调用方法打印字符串
        printString.printStringMethod();
        //main线程睡眠1000毫秒
        try {
            //这个肯定是main线程休眠，如果是其他的线程休眠，见下面解释1
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("在main线程中修改打印标志");
        printString.setContinuePrint(false);
        /**
         * 修改完打印标志后，运行程序，查看程序运行结果
         * 程序不会停止，因为 printString.printStringMethod();方法调用后，该方法一直处于死循环状态，程序根本就执行不到
         * printString.setContinuePrint(false);语句
         * 解决办法：可以使用多线程技术
         */

    }

    /**
     * 定义类打印字符串
     */
    static class PrintString{
        private boolean continuePrint = true;

        public PrintString setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
            return this;
        }
        public void printStringMethod(){
            while(continuePrint){
                System.out.println(Thread.currentThread().getName());
                try {
                    //那么肯定写在这里，因为在start()开始之后，如果要想让这个线程休眠，那么就得进入这个线程中
                    //然后，才能休眠这个线程，明白了吧，我是明白了。
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
