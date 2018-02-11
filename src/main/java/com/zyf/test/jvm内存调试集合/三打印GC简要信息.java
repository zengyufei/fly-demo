package com.zyf.test.jvm内存调试集合;

/**
 * 运行此程序可以得到 GC 信息
 */
public class 三打印GC简要信息 {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参数：
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=3  -XX:+PrintGCTimeStamps
     */
    public static void testAllocation() {
        byte[][] allocation = new byte[10][];
        allocation[0] = new byte[1 * _1MB];
        allocation[1] = new byte[1 * _1MB];
        allocation[2] = new byte[1 * _1MB];
        allocation[3] = new byte[1 * _1MB];
        allocation[4] = new byte[1 * _1MB];
        allocation[5] = new byte[1 * _1MB];
        allocation[6] = new byte[1 * _1MB];
        allocation[7] = new byte[1 * _1MB];
        allocation[8] = new byte[1 * _1MB];
        allocation[8] = new byte[1 * _1MB];
        allocation[9] = new byte[1 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
    /*
     * 0.190: [GC (Allocation Failure) [PSYoungGen: 5172K->2046K(8192K)] 5172K->3078K(18432K), 0.0018251 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * 0.192: [GC (Allocation Failure) [PSYoungGen: 7408K->1992K(8192K)] 8440K->8144K(18432K), 0.0017895 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * 0.194: [Full GC (Ergonomics) [PSYoungGen: 1992K->0K(8192K)] [ParOldGen: 6152K->7905K(10240K)] 8144K->7905K(18432K), [Metaspace: 3259K->3259K(1056768K)], 0.0047416 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
     * Heap
     *  PSYoungGen      total 8192K, used 4330K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
     *   eden space 6144K, 70% used [0x00000000ff600000,0x00000000ffa3a870,0x00000000ffc00000)
     *   from space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
     *   to   space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
     *  ParOldGen       total 10240K, used 7905K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
     *   object space 10240K, 77% used [0x00000000fec00000,0x00000000ff3b85e8,0x00000000ff600000)
     *  Metaspace       used 3266K, capacity 4568K, committed 4864K, reserved 1056768K
     *   class space    used 354K, capacity 392K, committed 512K, reserved 1048576K
     * */
    /*
     Allocation Failure – 引起垃圾回收的原因 . 本次 GC 是因为年轻代中没有任何合适的区域能够存放需要分配的数据结构而触发的 .
     * 第一句中：
     * --- 使用 PSYoungGen 收集器 ：5172K->2046K(8192K), 0.0018251 secs 是说 GC 前用了 5172K 内存，GC 后还占用 2046K 内存，总共内存为 8192K。后面是此次 GC 时间
     * --- 为什么是 8192K 呢，因为 PSYoungGen = eden + from （6144K + 2048K）
     * --- 5172K->3078K(18432K) 在本次垃圾收集之前和之后整个堆内存的使用情况。18432K 总内存。
     * --- [Times: user=0.00 sys=0.00, real=0.00 secs]
     * ------ user – 此次垃圾回收 , 垃圾收集线程消耗的所有 CPU 时间 (Total CPU time).
     * ------ sys – 操作系统调用 (OS call) 以及等待系统事件的时间 (waiting for system event)
     * ------ real – 应用程序暂停的时间(Clock time). 由于串行垃圾收集器(Serial Garbage Collector)只会使用单个线程, 所以 real time 等于 user 以及 system time 的总和.
     * 第三句中：  Full GC（ 老年代 GC） 了，是清理整个堆空间—包括年轻代和永久代，其中 1992K->0K(8192K) 表示清除了整个新生代，将原来新生代的转移到了老年代，可以用过 6152K->7905K(10240K) 看到这样的情况。
     * */
}
