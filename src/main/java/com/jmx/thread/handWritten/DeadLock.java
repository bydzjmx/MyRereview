package com.jmx.thread.handWritten;


/**
 * 简易死锁程序
 * 死锁指两个或两个以上进程在执行过程中，由于竞争资源或者通信造成的一种阻塞现象
 * A线程等待B线程持有的锁，B线程等待A线程持有的锁，发送死锁
 */
public class DeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        //做两个线程启动,synchronized
        new Thread(()->{
            synchronized (lock1){
                sleep(2000);
                System.out.println("线程1，等待lock2");
                synchronized (lock2){
                    System.out.println("获取到lock2，线程1完成");
                }
            }
        }).start();

        //线程2启动
        new Thread(()->{
            synchronized (lock2){
                sleep(2000);
                System.out.println("线程2，等待lock1");
                synchronized (lock1){
                    System.out.println("线程2完成，获取到lock1");
                }
            }
        }).start();
    }

    private static void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
