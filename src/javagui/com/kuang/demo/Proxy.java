package com.kuang.demo;

public class Proxy implements Rent{

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

    //看房，中介可以，房东不可以，你可以找中介看n套房子
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    //看房
    public void hetong(){
        System.out.println("签合同");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}


