package com.zyf.test.多线程.重入锁ReadWriteLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 依赖于 Lock 接口，生成一个 Condition 的基本代码是 lock.newCondition()
 * 调用 Condition 的 await() 和 signal() 方法，都必须在 lock 保护之内，就是说必须在 lock.lock() 和 lock.unlock 之间才可以使用
 * Conditon 中的 await() 对应 Object 的 wait()；
 * Condition 中的 signal() 对应 Object 的 notify()；
 * Condition 中的 signalAll() 对应 Object 的 notifyAll()。
 */
public class Condition条件线程协作 {

    public static void main(String[] args) {
        final ReentrantLock lock1 = new ReentrantLock(false);
        final ReentrantLock lock2 = new ReentrantLock(false);
        final Condition notity1 = lock1.newCondition();
        final Condition notity2 = lock2.newCondition();

        /*
         * 调用 notity1.signal() 只会唤醒 notity1.await() 下的消费者线程。
         * 调用 notity2.signal() 只会唤醒 notity2.await() 下的消费者线程。
         */
        new Thread(() -> {
            long start = System.currentTimeMillis();
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + "拿到锁");
            System.out.println(Thread.currentThread().getName() + "线程挂起，等待信号。");
            try {
                notity1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到信号，完成工作。");
            lock1.unlock();
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " 共执行" + (end - start) + " 毫秒");
        }, "线程一 ").start();

        new Thread(() -> {
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + "拿到锁");
            System.out.println(Thread.currentThread().getName() + "执行工作");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "工作执行完毕！通知其他线程");
            notity1.signal();
            lock1.unlock();
        }, "线程二 ").start();

        new Thread(() -> {
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + "拿到锁");
            System.out.println(Thread.currentThread().getName() + "线程挂起，等待信号。");
            try {
                notity2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到信号，完成工作。");
            lock2.unlock();
        }, "其他线程三 ").start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + "拿到锁");
            System.out.println(Thread.currentThread().getName() + "执行工作");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "工作执行完毕！通知其他线程");
            notity2.signal();
            lock2.unlock();
            long end = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " 共执行" + (end - start) + " 毫秒");
        }, "其他线程四 ").start();
    }

}
