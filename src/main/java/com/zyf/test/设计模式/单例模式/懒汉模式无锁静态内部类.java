package com.zyf.test.设计模式.单例模式;

public class 懒汉模式无锁静态内部类 {

    private static class 懒汉模式无锁静态内部类单例Holder {
        public static 懒汉模式无锁静态内部类单例 instance = new 懒汉模式无锁静态内部类单例();
    }

    public static void main(String[] args) {
        懒汉模式无锁静态内部类单例 单例 = 懒汉模式无锁静态内部类单例.newInstance();
        单例.sayHello();
    }

    static class 懒汉模式无锁静态内部类单例 {
        /**
         * 只要应用中不使用内部类，JVM 就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载。也就是说这种方式可以同时保证延迟加载和线程安全。
         */
        public static 懒汉模式无锁静态内部类单例 newInstance() {
            return 懒汉模式无锁静态内部类单例Holder.instance;
        }

        public void sayHello() {
            System.out.println("hahaha");
        }
    }
}
