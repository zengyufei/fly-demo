package com.zyf.test.多线程.yield和join;

public class Join测试 {

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            try {
                System.out.println("进行线程 1");
                Thread.sleep(500);
                System.out.println("线程 1 执行完毕！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        // 当仅打开主线程中的 join 调用代码时，则会阻塞主线程，thread2  要等待 thread1  执行完毕后，再执行
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final Thread thread2 = new Thread(() -> {
            System.out.println("进行线程 2");
            // 当仅打开 thread2 中的 join  调用代码时，thread2 线程会执行，但会阻塞 thread2 join 后面的代码，必须等待 thread1 完成， thread2 才完成
            /*try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("线程 2 执行完毕！");
        });

        thread2.start();


    }

}
