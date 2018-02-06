package com.zyf.test.设计模式.装饰者模式.构造方式装饰;

public class 运行 {

    public static void main(String[] args) {
        被装饰类 o = new 被装饰类();
        装饰类 t = new 装饰类(o);
        t.sayHello();
    }
}
