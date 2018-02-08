package com.zyf.test.设计模式.单例模式;

public class 懒汉模式线程安全效率高 {

    public static void main(String[] args) {
        懒汉模式线程安全效率高单例 单例 = 懒汉模式线程安全效率高单例.newInstance();
        单例.sayHello();
    }

    static class 懒汉模式线程安全效率高单例 {
        private static 懒汉模式线程安全效率高单例 instance = null;

        /**
         * 这样当单例创建完毕后，不用每次都进入同步代码块，从而能提升效率。
         */
        public static 懒汉模式线程安全效率高单例 newInstance() {
            if (instance == null) {
                synchronized (懒汉模式线程安全效率高单例.class) {
                    if (instance == null) {
                        instance = new 懒汉模式线程安全效率高单例();
                    }
                }
            }
            return instance;
        }

        public void sayHello() {
            System.out.println("hahaha");
        }
    }
}
