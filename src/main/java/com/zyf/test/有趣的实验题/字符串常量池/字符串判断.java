package com.zyf.test.有趣的实验题.字符串常量池;

public class 字符串判断 {

    public static void main(String[] args) {
        notFinalString();
        System.out.println("--------------------");
        finalString();
    }

    private static void notFinalString() {
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "ab";
        String s4 = "c";
        String s5 = "ab" + "c";
        String s6 = s3 + s4;
        String s7 = "ab" + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
        System.out.println(s1 == s7);
        /*
         * 分析：
         * -- 首先 s1 == s2 = false            是因为s2 new String 是内存中生成，s1 是字符串常量池生成，字符串常量池内存不是同一块内存。
         * -- s1 == s5 = true                 在字节码层面，s1 直接量 与 s5 两个直接量用重载符 + 号是一样的，背后的操作是 + 的两个直接量通过 StringBuilder 合并后，形成的新结果会调用 intern() 一次
         * -- s1 == s6 = false                因为s3 与 s4 是引用，对于引用重载符会调用 StringBuilder 合并，但不会调用 intern()
         * -- s1 == s6.intern() = true        因为s6.intern() 就主动声明，我要入常量池，所以为 true
         * -- s2 == s2.intern() = false       因为 s2.intern() 有两步操作，一是放入常量池，二是返回指向常量池的引用，请注意，此时的 s2.intern() 赋值的话，返回的已经不是同一个对象了。所以为 false
         * -- s1 == s7 = false                s7 = 常量 + 变量 不会进入常量池，因为不会等于 s1
         * 没有 final 时，最简单的记忆方法：
         * ------    常量 + 常量 = 入常量池
         * ------    常量 + 变量 = 不入常量池
         * ------    变量 + 变量 = 不入常量池
         * 如果有 final，则上面公式的变量自动转换成常量，全部都入常量池
         * */
    }

    private static void finalString() {
        final String s1 = "abc";
        final String s2 = new String("abc");
        final String s3 = "ab";
        final String s4 = "c";
        final String s5 = "ab" + "c";
        final String s6 = s3 + s4;
        final String s7 = "ab" + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
        System.out.println(s1 == s7);
    }
}
