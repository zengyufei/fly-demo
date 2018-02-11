LinkedBlockingQueue 和 ArrayBlockingQueue 迥异

通过上述的分析，对于 LinkedBlockingQueue 和 ArrayBlockingQueue 的基本使用以及内部实现原理我们已较为熟悉了，这里我们就对它们两间的区别来个小结

1. 队列大小有所不同，ArrayBlockingQueue 是有界的初始化必须指定大小，而 LinkedBlockingQueue 可以是有界的也可以是无界的 (Integer.MAX_VALUE)，对于后者而言，当添加速度大于移除速度时，在无界的情况下，可能会造成内存溢出等问题。

2. 数据存储容器不同，ArrayBlockingQueue 采用的是数组作为数据存储容器，而 LinkedBlockingQueue 采用的则是以 Node 节点作为连接对象的链表。

3. 由于 ArrayBlockingQueue 采用的是数组的存储容器，因此在插入或删除元素时不会产生或销毁任何额外的对象实例，而 LinkedBlockingQueue 则会生成一个额外的 Node 对象。这可能在长时间内需要高效并发地处理大批量数据的时，对于 GC 可能存在较大影响。

4. 两者的实现队列添加或移除的锁不一样，ArrayBlockingQueue 实现的队列中的锁是没有分离的，即添加操作和移除操作采用的同一个 ReenterLock 锁，而 LinkedBlockingQueue 实现的队列中的锁是分离的，其添加采用的是 putLock，移除采用的则是 takeLock，这样能大大提高队列的吞吐量，也意味着在高并发的情况下生产者和消费者可以并行地操作队列中的数据，以此来提高整个队列的并发性能。