package com.jmx.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger做全局计数器
 */
public class MyAtomicIntegerTest {

    private static final int THREADS_COUNT = 20;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void increase(){
        count.incrementAndGet();
    }

    public static void main(String[] args) {
        //多线程
        Thread[] threads = new Thread[THREADS_COUNT];
        //模拟多线程
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                        System.out.println("当前的线程是：" + Thread.currentThread().getName() + " 当前的数值是：" + count);
                    }
                }
            });
            threads[i].start();
        }
            while (Thread.activeCount() > 1) {
                Thread.yield();
            }
        System.out.println(count);
        }

}

