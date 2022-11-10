package com.wkcto.producerdata;

/**
 * 这是生产者，主要是用来生产数据
 * 就是调用valueop类的setvalue方法，给value字段赋值
 *  实现多线程的三种方式
 *  1，继承thread类，重写run方法
 *  2，实现runnable接口，重写run方法
 */
public class ProducerThread extends Thread {
    private ValueOP obj;

    public ProducerThread(ValueOP obj) {
       this.obj = obj;
    }

    /**
     * 可以直接调用这个方法，然后进行赋值，但是那是单线程，没有灵魂
     * 使用start方法，让jvm调用run，程序就活了，就是多线程
     * 让他们自由的进行赋值。
     */
    @Override
    public void run() {
        while(true){
           obj.setValue();
        }
    }

}
