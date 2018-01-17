package com.zyf.test.多线程.用volatile;

public class 运行 {

    private static volatile boolean bChanged;

    public static void main(String[] args) throws InterruptedException {
        Thread 线程一 = new Thread() {

            @Override
            public void run() {
                for (; ; ) {
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                }
            }
        };
        Thread 线程二 = new Thread() {

            @Override
            public void run() {
                for (; ; ) {
                    bChanged = !bChanged;
                }
            }
        };


        线程一.start();
        Thread.sleep(1);
        线程二.start();
    }
}
