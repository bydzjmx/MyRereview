package com.jmx.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟实现BlockingQueue，底层采用lock
 */
public class MyBlockingQueue<E> {
    //有大小限制的队列
    private int limit;
    private List list;
    private ReentrantLock lock = new ReentrantLock();
    //构建多条件condition
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int limit) {
        this.limit = limit;
        this.list = new LinkedList<E>();
    }

    //put方法，会造成阻塞
    public void put(E e) throws InterruptedException{
        lock.lock();
        try {
            while(list.size()==limit){
                //满了，需要阻塞
                notFull.await();
            }
            //不满情况下，添加
            list.add(e);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //take方法，会造成阻塞
    public E take(E e) throws  InterruptedException{
        lock.lock();
        try {
            while(list.size()==0){
                //为空，阻塞获取
                notEmpty.await();
            }
            E remove = (E) list.remove(0);
            notFull.signalAll();
            return remove;
        } finally {
            lock.unlock();
        }
    }
}
