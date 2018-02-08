package com.zyf.test.设计模式.单例模式;

public class 饿汉模式 {

    public static void main(String[] args) {
        饿汉单例 单例 = 饿汉单例.newInstance();
        单例.sayHello();
    }

    static class 饿汉单例 {
        private static 饿汉单例 instance = new 饿汉单例();

        public static 饿汉单例 newInstance() {
            return instance;
        }

        public void sayHello() {
            System.out.println("hahaha");
        }
    }
}
