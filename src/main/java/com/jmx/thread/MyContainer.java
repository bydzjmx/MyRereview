package com.jmx.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 * @author jmx
 */
public class MyContainer<T> {
    private final LinkedList<T> lists = new LinkedList<>();
    private final int MAX = 10;  //最多10个元素
    private int count = 0;

    //生产者的新增方法()
    public synchronized void put(T t){
        while(lists.size() == MAX){
            try {
                this.wait();  //满了时等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果不满
        lists.add(t);
        ++count;
        this.notifyAll();  //通知消费者线程进行消费
    }

    //消费者的get方法
    public synchronized T get(){
        T t = null;
        while(lists.size()==0){
            try {
                this.wait();  //等待，有变量时再消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        T t1 = lists.removeFirst();
        count--;
        this.notifyAll();    //通知生产者进行生成
        return t1;
    }

    public static void main(String[] args) {
        MyContainer<String> c = new MyContainer<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++)
                    System.out.println(c.get());
            },"c"+i).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int j = 0; j < 25; j++)
                    c.put(Thread.currentThread().getName()+" "+j);

            },"p"+i).start();
        }

    }

}
