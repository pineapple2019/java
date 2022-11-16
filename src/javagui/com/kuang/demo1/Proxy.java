package com.kuang.demo1;

public class Proxy implements Rent {
    private Host host;
    public Proxy(){
    }

    public Proxy(Host host){
        this.host=host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        hetong();
        fare();
    }
    //中介可以带你看n套房子
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    //签合同
    public void hetong(){
        System.out.println("签合同");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
