package com.zyf.test.设计模式.单例模式;

import java.util.HashSet;
import java.util.Set;

/**
 *  存在线程安全性问题
 */
public class 测试线程问题的懒汉模式 {

    /**
     * 如果打印出两个对象在 set 里面，而且 hash 值不一样，则说明线程出线程问题了，单例应该只有一个对象
     */
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.singles);
    }

    static class ThreadTest implements Runnable {
        //存放单例对象，使用Set是为了不存放重复元素
        public Set<懒汉模式.懒汉单例> singles = new HashSet<>();

        @Override
        public void run() {
            //获取单例
            懒汉模式.懒汉单例 s = 懒汉模式.懒汉单例.newInstance();
            //添加单例
            singles.add(s);
        }
    }


}

