package com.zyf.test.队列.FIFO队列;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * ArrayBlockingQueue  由于其底层基于数组，并且在创建时指定存储的大小，在完成后就会立即在内存分配固定大小容量的数组元素，因此其存储通常有限，故其是一个 “有界 “的阻塞队列。
 * LinkedBlockingQueue  作为阻塞队列的原因就在于其无界性。因为线程大小固定的线程池，其线程的数量是不具备伸缩性的，当任务非常繁忙的时候，就势必会导致所有的线程都处于工作状态，
 * 如果使用一个有界的阻塞队列来进行处理，那么就非常有可能很快导致队列满的情况发生，从而导致任务无法提交而抛出 RejectedExecutionException，而使用无界队列由于其良好的存储容量的伸缩性，
 * 可以很好的去缓冲任务繁忙情况下场景，即使任务非常多，也可以进行动态扩容，当任务被处理完成之后，队列中的节点也会被随之被 GC 回收，非常灵活。
 */
public class LinkedBlockingQueue测试 {

    public static void main(String[] args) {
        int initCapacity = 1000;
        LinkedBlockingQueue queue = new LinkedBlockingQueue<>(); // 默认大小是 Integer.MAX_VALUE，所以你放多少都可以

        new Thread(() -> {
            int i = 0;
            for (; i < initCapacity; i++) {
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " = 放入第 " + i + " 个");
                }
            }
        }, "线程 1").start();

        new Thread(() -> {
            int i = 0;
            for (; i < initCapacity; i++) {
                try {
                    queue.take();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(Thread.currentThread().getName() + " = 取出第 " + i + " 个");
                }
            }
        }, "线程 二").start();


    }

}
