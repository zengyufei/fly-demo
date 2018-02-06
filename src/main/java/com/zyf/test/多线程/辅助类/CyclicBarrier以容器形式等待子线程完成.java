package com.zyf.test.多线程.辅助类;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier以容器形式等待子线程完成 {

    public static void main(String[] args) {
        int initCapacity = 4;
        int forCapacity = 4;
        CyclicBarrier cb = new CyclicBarrier(initCapacity);

        for (int i = 0; i < forCapacity; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 正在执行。");
                    Thread.sleep(5000);
                    System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                    cb.await();
                    System.out.println("所有线程写入完毕，继续处理其他任务...");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
