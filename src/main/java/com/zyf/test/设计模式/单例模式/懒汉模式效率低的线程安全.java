package com.zyf.test.设计模式.单例模式;

/**
 *  线程安全，但效率低
 */
public class 懒汉模式效率低的线程安全 {

    public static void main(String[] args) {
        懒汉模式效率低的线程安全单例 单例 = 懒汉模式效率低的线程安全单例.newInstance();
        单例.sayHello();
    }

    static class 懒汉模式效率低的线程安全单例 {
        private static 懒汉模式效率低的线程安全单例 instance = null;

        /**
         * synchronized 修饰的同步方法比一般方法要慢很多，如果多次调用 getInstance()，累积的性能损耗就比较大了。
         */
        public static synchronized 懒汉模式效率低的线程安全单例 newInstance() {
            if (null == instance) {
                instance = new 懒汉模式效率低的线程安全单例();
            }
            return instance;
        }

        public void sayHello() {
            System.out.println("hahaha");
        }
    }

}
