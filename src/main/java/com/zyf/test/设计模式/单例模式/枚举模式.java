package com.zyf.test.设计模式.单例模式;

public class 枚举模式 {


    public static void main(String[] args) {
        懒汉模式无锁静态内部类单例 单例 = 枚举单例.instance.newInstance();
        单例.sayHello();
    }

    public enum 枚举单例 {
        instance;

        private 懒汉模式无锁静态内部类单例 单例;

        枚举单例() {
            this.单例 = new 懒汉模式无锁静态内部类单例();
        }

        private 懒汉模式无锁静态内部类单例 newInstance() {
            return 单例;
        }
    }

    static class 懒汉模式无锁静态内部类单例 {

        public void sayHello() {
            System.out.println("hahaha");
        }
    }
}


