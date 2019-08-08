package com.jmx.thread.handWritten;

/**
 * 设计4个线程、实现2个线程对i加一，2个线程对i进行减一
 */
public class Test2 {
    private int i = 5;
    private synchronized void increase(){
        while(i<10){
            i++;
            System.out.println(Thread.currentThread().getName()+"加"+i);
        }
    }
    private  synchronized void decrease(){
        while(i>0){
            i--;
            System.out.println(Thread.currentThread().getName()+"减"+i);
        }
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        //两个线程加1
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                t.increase();
            }).start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //两个线程减1
            new Thread(()->{
                t.decrease();
            }).start();
        }

    }

}
