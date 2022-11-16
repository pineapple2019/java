package com.kuang.demo1;

public class Client {
    public static void main(String[] args) {
        /**
         * 房东要出租房子
         * 这样，房东只能有出租房子，这一个原始功能
         *         Host host=new Host();
         *         host.rent();
         */

        /**
         *使用代理，就可以有很多功能由房东来做
         */

        Host host= new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
