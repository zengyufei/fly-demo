package com.zyf.test.队列.FIFO队列;

import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

class User implements Comparable<User> {

    public Integer priority;
    public String username;

    @Override
    public int compareTo(User user) {
        return this.priority.compareTo(user.priority); // 1 是大于 0 是等于 -1 是小于
    }
}

public class PriorityBlockQueue具有优先级的队列 {

    public static void main(String[] args) {
        int forCapacity = 12;
        PriorityBlockingQueue<User> queue = new PriorityBlockingQueue<>();
        for (int i = 0; i < forCapacity; i++) {
            /*
             * 随机产生优先级
             */
            int max = 20;
            int min = 10;
            Random random = new Random();

            User user = new User();
            user.priority = random.nextInt(max) % (max - min + 1) + min;
            user.username = "第" + (i + 1) + "个";

            queue.add(user);
        }

        for (int i = 0; i < forCapacity; i++) {
            User u = queue.poll();
            System.out.println("优先级是：" + u.priority + "，" + u.username);
        }
    }
}