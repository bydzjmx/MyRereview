package com.jmx.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子操作技术类的使用,Atomic类
 * @author jmx
 */
public class ConcurrentTest {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        //创建多线程
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    count.incrementAndGet();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(count);
        AtomicReference<Object> reference = new AtomicReference<>();
        //compareAndSet，第一个值为期望值，即内存中的值，第二个值是新值，即要更新的值
        reference.compareAndSet(null,null);
    }
}
