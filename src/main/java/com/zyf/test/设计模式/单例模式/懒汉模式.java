package com.zyf.test.设计模式.单例模式;

/**
 *  存在线程安全性问题
 */
public class 懒汉模式 {

    public static void main(String[] args) {
        懒汉单例 单例 = 懒汉模式.懒汉单例.newInstance();
        单例.sayHello();
    }

    static class 懒汉单例 {
        private static 懒汉单例 instance = null;

        /**
         * 懒汉模式并没有考虑线程安全问题，在多个线程可能会并发调用它的 getInstance() 方法，导致创建多个实例
         */
        public static 懒汉单例 newInstance() {
            if (null == instance) {
                instance = new 懒汉单例();
            }
            return instance;
        }

        public void sayHello() {
            System.out.println("hahaha");
        }
    }

}
