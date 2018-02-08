package com.zyf.test.队列.FIFO队列;

import java.util.concurrent.SynchronousQueue;

/**
 * put 线程执行 queue.put(1) 后就被阻塞了，只有 take 线程进行了消费，put 线程才可以返回。可以认为这是一种线程与线程间一对一传递消息的模型。
 * 生产者和消费者互相等待对方，握手，然后一起离开。
 * Executors.newCachedThreadPool()  就默认使用了 SynchronousQueue
 */
public class SynchronousQueue测试 {

    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        Thread putThread = new Thread(() -> {
            System.out.println("放入元素");
            try {
                queue.put(1); // 放入后阻塞，必须等到 take 出去后才继续
            } catch (InterruptedException e) {
            }
            System.out.println("放入完毕");
        });

        Thread takeThread = new Thread(() -> {
            System.out.println("取出元素");
            try {
                Thread.sleep(1000);
                System.out.println("取出了一个元素: " + queue.take());
            } catch (InterruptedException e) {
            }
            System.out.println("取出完毕");
        });

        putThread.start();
        takeThread.start();
    }

}
