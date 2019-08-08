package com.jmx.thread;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * 消费者生产者模式: 阻塞调用,sleep,notifyAll
 * @author jmx
 */
public class MyTest<T> {
    //定义容器
    private LinkedList<T> lists = new LinkedList<T>();
    //定义最大容量
    private final int MAX_COUNT = 10;
    //定义初始容量
    private int count = 0;

    //构建生产者的新增方法
    public synchronized void put(T t) throws InterruptedException {
        //只有当容量不满时才可以新增,容量满了,进入阻塞
        while (lists.size() == MAX_COUNT) {
            this.wait();
        }
        lists.add(t);
        count++;
        //通知消费者线程进行消费
        this.notifyAll();
    }

    //构建消费者的消费方法
    public synchronized T get() throws InterruptedException {
        while(lists.size() ==0 ){
            //没有内容,需要进行阻塞等待
            this.wait();
        }
        //返回第一个数
        T t = lists.removeFirst();
        count--;
        //唤醒生产者线程进行生产
        this.notifyAll();
        return t;
    }

    //模拟生产者消费者模式,分别启动生产者模式和消费者模式
    public static void main(String[] args) throws InterruptedException {
        MyTest<String> myTest = new MyTest();
        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                //进行生产
                for (int j = 0; j < 25; j++) {
                    try {
                        //放入线程名
                        myTest.put(Thread.currentThread().getName()+"由以下线程生产"+j);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("生产完成");

        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 6; j++) {
                    try {
                        String s = myTest.get();
                        System.out.println(s);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            TimeUnit.SECONDS.sleep(1);

        }
    }
}
