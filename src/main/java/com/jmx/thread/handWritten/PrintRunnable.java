package com.jmx.thread.handWritten;

/**
 * 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15.
 * 接着再由线程1打印16,17,18,19,20….以此类推, 直到打印到75. 程序的输出结果应该为:
 *
 * 线程1: 1
 * 线程1: 2
 * 线程1: 3
 * 线程1: 4
 * 线程1: 5
 *
 * 线程2: 6
 * 线程2: 7
 * 线程2: 8
 * 线程2: 9
 * 线程2: 10
 * …
 *
 * 线程3: 71
 * 线程3: 72
 * 线程3: 73
 * 线程3: 74
 * 线程3: 75
 */
public class PrintRunnable implements Runnable{
    //解法1，使用静态变量存储变量，在所有线程间可见
    private static volatile int printNum = 0;
    //通过线程id区分不同的线程
    private int threadId;
    private Object o;

    public PrintRunnable(int threadId, Object o) {
        this.threadId = threadId;
        this.o = o;
    }

    @Override
    public void run() {
        //当未添加到75时，线程输出
        while(printNum<75){
            synchronized (o){
                //对应的线程输出对应的数
                if(printNum/5%3 + 1 == threadId){
                    //输出5个数
                    for (int i = 0; i < 5; i++) {
                        System.out.println("线程："+threadId+":"+(++printNum));
                    }
                    o.notifyAll();
                }
                else {
                    //如果是其他线程，等待
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //创建三个线程执行任务,三个对象持有相同的对象，对该对象进行加锁，控制并发
        Object o = new Object();
        new Thread(new PrintRunnable(1,o)).start();
        new Thread(new PrintRunnable(2,o)).start();
        new Thread(new PrintRunnable(3,o)).start();
    }
}