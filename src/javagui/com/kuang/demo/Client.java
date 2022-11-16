package com.kuang.demo;

public class Client {
    public static void main(String[] args) {
        //房东要租房子
        Host host = new Host();
        //host.rent();
        //代理，中介帮房东租房子，但是，代理会有一些附属的操作
        Proxy proxy = new Proxy(host);

        //你不用面对房东，直接找中介租房子即可
        proxy.rent();

    }

}
