package com.kuang.demo2;

//真实对象，这个是实现了接口
public class UserServiceImpl implements UserService{

    @Override
    public void add() {

        //在实现这个任务前面，加一个日志,在程序中有一个原则，尽量不要改变原有的代码
      //  System.out.println("使用了add方法");
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
      //  System.out.println("使用了add方法");

        System.out.println("删除了一个用户");

    }

    @Override
    public void update() {
       // System.out.println("使用了add方法");

        System.out.println("修改了一个用户");

    }

    @Override
    public void query() {
      //  System.out.println("使用了add方法");

        System.out.println("查询了一个用户");

    }
}
