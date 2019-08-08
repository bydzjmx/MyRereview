package com.jmx.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch，门闩控制并非
 * 重点： 一个线程等待await，等待其他N个线程完成某件事情后（countDown）执行
 * 与CyclicBarrier区别：不能重复使用已使用的障碍，同时一个线程等待N个线程之后执行
 */
public class CountDownLatchDemo2 {
    /**
     * demo1 线程准备完成后一起执行
     */
    private static final int THREAD_NUM = 10;

    public static void main(String[] args) {
        //创建countDownLatch
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < THREAD_NUM; i++) {
            es.submit(new CountDownLatchTask(latch,"Thread-"+i));
        }
        try {
            //门闩值不为0时，阻塞，为0时放开
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大家都执行完成了，做总结性工作");
        es.shutdown();
    }

    private static class CountDownLatchTask implements Runnable{
        private final CountDownLatch latch;
        private final String threadName;

        public CountDownLatchTask(CountDownLatch latch, String threadName) {
            this.latch = latch;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            System.out.println(threadName + " 执行完成");
            latch.countDown();
        }
    }
}
