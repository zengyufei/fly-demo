package com.zyf.test.多线程.辅助类;

import java.util.concurrent.Semaphore;

public class Semaphore利用令牌资源阻塞等待子线程 {

    /**
     * Semaphore 翻译成字面意思为 信号量，Semaphore 可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
     */
    public static void main(String[] args) {
        int initCapacity = 2;
        int forCapacity = 4;
        Semaphore s = new Semaphore(initCapacity);
        for (int i = 0; i < forCapacity; i++) {
            new Thread(() -> {
                try {
                    s.acquire();
                    System.out.println(Thread.currentThread().getName() + " 正在执行。");
                    Thread.sleep(5000);
                    System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                    s.release();
                    System.out.println("拿到令牌的所有子线程写入完毕，继续处理其他线程...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
