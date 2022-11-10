package com.wkcto.producerdata;

/**
 * 定义一个操作数据的类
 * 实现目的，能够实现
 * 当空间中有数据时，消费者消费，生产者生产
 *  无数据时，消费者等待（停止消费），生产者生产
 *  满数据时，消费者消费，生产者等待（停止生产）
 */
public class ValueOP {
    private String value = "";

    //this代表的是本类中成员变量的访问

    //定义方法修改value字段的值

    public void setValue() {
        this.value = value;
        //如果不是空串就等待，就是说，不是空串， 就不用触发这个修改的函数
        //否则是空串，那么就需要修改设置value值
        synchronized (this){
            //如果value值不是“”空串就等待
            try {
                this.wait(); //如果不是空值，那么就等待，就不会继续向下继续了
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //如果value字段值是空串，就设置value字段的值
            String value = System.currentTimeMillis()+"-"+System.nanoTime();
            System.out.println("set设置的值是："+value);
            this.value = value;
        }//同步代码块
    }

    //定义方法读取value字段的值，这个是消费者调用的方法，
    public void getValue() {
        synchronized (this){
            //如果是空串，就不能获取值，就得等生产者生产数据，等待
            while(value.equalsIgnoreCase("")){
                try {
                    this.wait();    //因为没有数据，所以就得等待。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //如果不是空串，消费者可以拿取数据
                System.out.println("get的值是："+this.value);
                this.value = "";    //拿完数据之后，要模拟一下，把value的值设置为空
            }
        }
    }
}
