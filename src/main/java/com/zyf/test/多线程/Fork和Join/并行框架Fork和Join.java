package com.zyf.test.多线程.Fork和Join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


public class 并行框架Fork和Join extends RecursiveTask {

    private static final int THRESHOLD = 2;//阈值
    private int start;
    private int end;

    public 并行框架Fork和Join(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            并行框架Fork和Join leftTask = new 并行框架Fork和Join(start, middle);
            并行框架Fork和Join rightTask = new 并行框架Fork和Join(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果
            int leftResult = Integer.parseInt(leftTask.join().toString());
            int rightResult = Integer.parseInt(rightTask.join().toString());
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务，负责计算+++
        并行框架Fork和Join task = new 并行框架Fork和Join(1, 4);
        //执行一个任务
        Future result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
