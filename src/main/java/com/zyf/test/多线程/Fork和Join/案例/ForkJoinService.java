package com.zyf.test.多线程.Fork和Join.案例;

import java.util.concurrent.RecursiveTask;

public abstract class ForkJoinService<T> extends RecursiveTask<T> {
    @Override
    protected abstract T compute();
}  