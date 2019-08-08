package com.jmx.thread.handWritten;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 现有的程序代码模拟产生了16个日志对象，并且需要运行16秒才能打印完这些日志，
 * 请在程序中增加4个线程去调用parseLog()方法来分头打印这16个日志对象，程序只需要运行4秒即可打印完这些日志对象
 */
public class Print {
    //parseLog方法内部的代码不能改动
    public static void parseLog(String log){
        System.out.println(log+":"+(System.currentTimeMillis()/1000));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //构建16个日志对象
        final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(16);
        //模拟生成日志
        for (int i = 0; i < 16; i++) {
            String log = ""+(i+1);
            //放入队列中
            try {
                queue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //构建4个线程
        System.out.println(queue.toString());
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
               while(queue.size()>0){
                   try {
                       parseLog(queue.take());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }).start();
        }
    }
}
