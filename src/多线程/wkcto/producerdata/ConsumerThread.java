package 多线程.wkcto.producerdata;

/**
 *
 * 定义线程类模拟消费者
 * 消费者的任务就是不断的消费，使用valueop类的value值
 */
public class ConsumerThread extends Thread {
    private ValueOP obj; //疑惑，为啥没有new一个对象，而是通过这样直接定义一个自己定义的对象

    public ConsumerThread(ValueOP obj) {
        this.obj = obj;
    }

    /**
     * 通过上面没有new 的对象，进行调用方法，我很不解
     */
    @Override
    public void run() {
      while(true){
          obj.getValue();
      }

    }
}
