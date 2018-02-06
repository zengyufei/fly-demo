package com.zyf.test.队列.FIFO队列;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class ArrayBlockingQueue测试 {

    public static void main(String[] args) {
        /*
         * 会无限循环放入取出放入取出
         */
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);
        Thread thread1 = new Thread(new 线程1(queue));
        thread1.start();
        new Thread(new 线程2(queue)).start();
    }

    @Test
    public void 测试阻塞() {
        int initCapacity = 10;
        int forCapacity = 20;
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(initCapacity);
        for (int i = 0; i < forCapacity; i++) {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("被阻塞则永远无法打印，必须使用线程。");
    }

    static class 线程1 implements Runnable {
        CountDownLatch cd = new CountDownLatch(10);
        ArrayBlockingQueue<Object> abq;

        public 线程1(ArrayBlockingQueue<Object> outArrayBlocking) {
            abq = outArrayBlocking;
        }

        @Override
        public void run() {
            while (cd.getCount() > 0) {
                try {
                    abq.put(cd.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("放入了元素");
                }
                cd.countDown();
            }
        }
    }

    static class 线程2 implements Runnable {
        CountDownLatch cd = new CountDownLatch(10);
        ArrayBlockingQueue<Object> abq;

        public 线程2(ArrayBlockingQueue<Object> outArrayBlocking) {
            abq = outArrayBlocking;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    abq.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("取出了元素");
                }
                cd.countDown();
            }
        }
    }


}
