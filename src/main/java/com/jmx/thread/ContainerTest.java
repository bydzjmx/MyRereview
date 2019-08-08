package com.jmx.thread;

import java.util.LinkedList;

/**
 * 生产者消费者模型
 *  * 写一个固定容量同步容器，拥有生产put和消费get方法，以及getCount方法，
 *  * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 */
public class ContainerTest<T> {
    private final LinkedList<T> list = new LinkedList<>();
    //最多10个元素
    private final int MAX = 10;
    private int count = 0;

    //构建生产者的生产方法,调用该方法，会放元素进入容器中
    public synchronized void put(T t){
        //首先判断容器是否已满
        while (list.size()==MAX){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //容器不满，进行添加
        list.add(t);
        count++;
        //通知消费者线程进行消费
        this.notifyAll();
    }

    //构建消费者
    public synchronized T get(){
        T t = null;
        //判断容器是否为空
        while(list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //进行获取，给与第一个值
        t = list.removeFirst();
        count--;
        //唤醒生产者进行生产
        this.notifyAll();
        return t;
    }

    //主线程开启生产者和消费者
    public static void main(String[] args) {
        ContainerTest c = new ContainerTest();
        //启动2生产者和10消费者线程
        for (int i = 0; i < 10; i++) {
            //每个线程消费5个
            for (int j = 0; j < 5; j++) {
                new Thread(()->{
                    System.out.println(c.get());
                },"c"+i).start();
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                //每个线程生产25个数，生产的顺序是随机的
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName()+" "+j);
                }
            },"p"+i).start();
        }
    }
}
