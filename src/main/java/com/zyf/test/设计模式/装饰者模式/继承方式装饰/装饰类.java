package com.zyf.test.设计模式.装饰者模式.继承方式装饰;

public class 装饰类 extends 被装饰类 {

    @Override
    public void sayHello() {
        System.out.println("装饰一下 start");
        super.sayHello();
        System.out.println("装饰一下 end");
    }
}
