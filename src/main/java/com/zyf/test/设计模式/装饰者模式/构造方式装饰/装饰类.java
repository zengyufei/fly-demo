package com.zyf.test.设计模式.装饰者模式.构造方式装饰;

public class 装饰类 {

    被装饰类 t;

    public 装饰类(被装饰类 o) {
        t = o;
    }

    public void sayHello() {
        System.out.println("装饰一下 start");
        t.sayHello();
        System.out.println("装饰一下 end");
    }
}
