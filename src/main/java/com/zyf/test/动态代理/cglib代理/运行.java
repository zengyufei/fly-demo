package com.zyf.test.动态代理.cglib代理;

public class 运行 {

    public static void main(String[] args) {
        Cglib代理类 proxy = new Cglib代理类();
        // 通过生成子类的方式创建代理类
        被代理对象 proxyImp = (被代理对象) proxy.getProxy(被代理对象.class);
        proxyImp.say();
    }

}
