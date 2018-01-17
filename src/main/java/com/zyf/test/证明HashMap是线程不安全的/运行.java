package com.zyf.test.证明HashMap是线程不安全的;

import java.util.HashMap;

/**
 * 多次执行会打印出东西，例如 0:null
 */
public class 运行 {

    public static final HashMap<String, String> firstHashMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {

        // 线程一 
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    firstHashMap.put(String.valueOf(i), String.valueOf(i));
                }
            }
        };

        // 线程二 
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int j = 25; j < 50; j++) {
                    firstHashMap.put(String.valueOf(j), String.valueOf(j));
                }
            }
        };

        t1.start();
        t2.start();

        // 主线程休眠 1 秒钟，以便 t1 和 t2 两个线程将 firstHashMap 填装完毕。
        Thread.currentThread().sleep(1000);

        for (int l = 0; l < 50; l++) {
            // 如果 key 和 value 不同，说明在两个线程 put 的过程中出现异常。
            if (!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))) {
                System.err.println(String.valueOf(l) + ":" + firstHashMap.get(String.valueOf(l)));
            }
        }

    }

}