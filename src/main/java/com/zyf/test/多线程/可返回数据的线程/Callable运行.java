package com.zyf.test.多线程.可返回数据的线程;

import java.util.concurrent.*;

public class Callable运行 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Callable callable1 = () -> {
            Thread.sleep(1000);
            long end = System.currentTimeMillis();
            System.out.println("test1 花费: " + (end - start) + "毫秒");
            return "aaa";
        };
        Callable callable2 = () -> {
            Thread.sleep(5000);
            long end = System.currentTimeMillis();
            System.out.println("test2 花费: " + (end - start) + "毫秒");
            return "bbb";
        };


        // 创建一个线程池
        ExecutorService pool = Executors.newScheduledThreadPool(2);
        Future submit1 = pool.submit(callable1);
        Future submit2 = pool.submit(callable2);

        try {
            String result1 = submit1.get().toString();
            String result2 = submit2.get().toString();
            // 数据是一起回来的，实际效果与使用 CountDownLatch 相同
            System.out.println("准备一起接收数据！");
            System.out.println(result1);
            System.out.println(result2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
