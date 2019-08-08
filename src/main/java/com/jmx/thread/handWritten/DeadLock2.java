package com.jmx.thread.handWritten;

public class DeadLock2 {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    //启动两个线程
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (obj1){
                sleep(2000L);
                System.out.println("obj1获取");
                synchronized (obj2){
                    System.out.println("obj2获取");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (obj2){
                sleep(2000L);
                System.out.println("obj2获取");
                synchronized (obj1){
                    System.out.println("obj1获取");
                }
            }
        }).start();
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
