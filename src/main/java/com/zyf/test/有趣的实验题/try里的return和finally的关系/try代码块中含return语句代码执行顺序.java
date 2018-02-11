package com.zyf.test.有趣的实验题.try里的return和finally的关系;

/**
 * java 规范都说了，finally 会在 try 代码块的 return 之前执行。
 * 但是，处理基本数据类型是不一样的！！！
 * finally 里面操作的是引用，如果遇到基本数据类型，会 copy 副本，导致在 try 里返回的不是 finally 里面的东西。而对象只是 copy 一个应用而已。
 * 可以这么说，基本数据类型没有在内存中，只是栈操作，而 finally 就是再复制栈一份出来，而对对象来说只是换了一个栈，引用还是同一块内存。
 */
public class try代码块中含return语句代码执行顺序 {

    public static void main(String[] args) {
        // 分三块测试
        // 1. try 里 return 基本数据 int i，finally 对 ++i 操作
        // 2. try 里 return 对象类型 User 里的 int i，finally 对 ++i 操作
        // 1. try 里 return 基本数据 int i，finally 对 ++i 操作，同时也 return i 出去
        System.out.println(one());
        System.out.println(two().i);
        System.out.println(three());
    }

    private static int one() {
        int i = 0;
        try {
            return i;
        } finally {
            ++i;
        }
    }

    static class User {
        int i = 0;
    }

    private static User two() {
        User user = new User();
        try {
            return user;
        } finally {
            ++user.i;
        }
    }

    private static int three() {
        int i = 0;
        try {
            return i;
        } finally {
            ++i;
            return i;
        }
    }


}
