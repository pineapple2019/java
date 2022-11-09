package 多态;
interface USB{
    void open();
    void close();
}

class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }
}

class Keyboard implements USB{
    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }
}

class Mac{

    public void run(){
        System.out.println("启动我的苹果电脑");
    }
    public void shutDown(){
        System.out.println("关闭我的mac");
    }
    public void extend(USB usb){
        if (usb!=null){
            usb.open();
            usb.close();
        }
    }

}

public class PcTest {
    public static void main(String[] args) {
        Mac mac = new Mac();
        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();
        mac.run();
        mac.extend(mouse);
        mac.extend(keyboard);
        mac.shutDown();
    }
}
