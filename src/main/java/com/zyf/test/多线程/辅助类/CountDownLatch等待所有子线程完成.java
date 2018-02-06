package com.zyf.test.多线程.辅助类;

import java.util.concurrent.CountDownLatch;

/**
 * 实现类似计数器
 */
public class CountDownLatch等待所有子线程完成 {

    /**
     * CountDownLatch  类只提供了一个构造器：
     * public CountDownLatch(int count) {  };  //参数count为计数值
     * 然后下面这 3 个方法是 CountDownLatch 类中最重要的方法：
     * public void await() throws InterruptedException { };   //调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
     * public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };  //和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
     * public void countDown() { };  //将count值减1
     */
    public static void main(String[] args) {
        int initCapacity = 2;
        CountDownLatch cd = new CountDownLatch(initCapacity);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
            cd.countDown();
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "正在执行");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕");
            cd.countDown();
        }).start();

        try {
            System.out.println("等待" + initCapacity + "个线程执行完毕。");
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程执行完毕！");
        System.out.println("继续主线程！");
    }
}
