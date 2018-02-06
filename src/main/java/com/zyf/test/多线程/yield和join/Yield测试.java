package com.zyf.test.多线程.yield和join;

/**
 * 多线程的执行流程：多个线程并发请求执行时，由 cpu 决定优先执行哪一个，
 * 即使通过 thread.setPriority()，设置了线程的优先级，也不一定就是每次都先执行它
 */
public class Yield测试 implements Runnable {

    /**
     * 其实默认情况下，多线程时，cpu 就会切换执行的任务线程，而 yield 方法，只是人为的通知系统，进行切换，
     * 且有一定机率能切换回本身
     */
    @Override
    public void run() {
        System.out.println("first: " + Thread.currentThread().getName());
        // 暂停当前正在执行的线程对象，并执行其他线程，就是进入就绪状态 
        Thread.currentThread().yield();
        // 可能还会执行   本线程 :  以下语句不一定紧接着上面的语句被执行，可能其他线程的先执行了
        System.out.println("second: " + Thread.currentThread().getName());

    }

    public static void main(String[] args) {
        /*
            多次运行，看运行结果
        */
        Yield测试 runn = new Yield测试();
        Thread t1 = new Thread(runn);
        Thread t2 = new Thread(runn);
        Thread t3 = new Thread(runn);

        t2.setPriority(t2.getPriority() + 1); // 设置 t2 的线程优先级
        t1.start();
        t2.start();
        t3.start();
    }
}    