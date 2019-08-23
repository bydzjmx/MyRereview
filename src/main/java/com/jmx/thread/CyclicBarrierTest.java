package com.jmx.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CyclicBarrier，循环barrier，当给定数量的线程等待时触发，同时解锁
 */
public class CyclicBarrierTest {
    private static final int THREAD_NUM = 10;

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_NUM, new Runnable() {
            @Override
            //达到10个线程await后，执行该线程并解锁
            public void run() {
                System.out.println("所有人都准备好了");
            }
        });
        //定义线程池
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < THREAD_NUM; i++) {
            es.submit(new CyclicBarrierTask(cyclicBarrier,"Thread-"+i));
        }
        es.shutdown();
    }

    //线程执行类
    static class CyclicBarrierTask implements Runnable{
        private CyclicBarrier cyclicBarrier;
        private String threadName;

        public CyclicBarrierTask(CyclicBarrier cyclicBarrier, String threadName) {
            this.cyclicBarrier = cyclicBarrier;
            this.threadName = threadName;
        }

        @Override
        public void run() {
            System.out.println(threadName+" 准备好了");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            //工作
            System.out.println(threadName+" 工作完成");
        }
    }
}