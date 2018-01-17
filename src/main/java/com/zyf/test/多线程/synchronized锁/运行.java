package com.zyf.test.多线程.synchronized锁;

public class 运行 {

    private static int i;

    private static Object object = new Object();

    public static void main(String[] args) throws Exception {
        有锁();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始无锁线程测试--------------------------------------------");
        无锁();
    }

    private static void 有锁() {
        Thread 线程一 = new Thread("线程一") {
            @Override
            public void run() {
                synchronized (object) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("有锁线程一结束");
                }
            }
        };
        Thread 线程二 = new Thread("线程二") {
            @Override
            public void run() {
                synchronized (object) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("有锁线程二结束");
                }
            }
        };
        Thread 线程三 = new Thread("线程三") {
            @Override
            public void run() {
                synchronized (object) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "：" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("有锁线程三结束");
                }
            }
        };

        线程一.start();
        线程二.start();
        线程三.start();

    }

    private static void 无锁() {
        Thread 线程四 = new Thread("线程四") {
            @Override
            public void run() {
                i++;
                System.out.println(Thread.currentThread().getName() + "：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("无锁线程四结束");
            }
        };
        Thread 线程五 = new Thread("线程五") {
            @Override
            public void run() {
                i++;
                System.out.println(Thread.currentThread().getName() + "：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("无锁线程五结束");
            }
        };
        Thread 线程六 = new Thread("线程六") {
            @Override
            public void run() {
                i++;
                System.out.println(Thread.currentThread().getName() + "：" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("无锁线程六结束");
            }
        };

        线程四.start();
        线程五.start();
        线程六.start();

    }

}
