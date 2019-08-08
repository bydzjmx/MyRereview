package com.jmx.thread.handWritten;

/**
 * 实现子线程先循环10次、接着主线程循环20、再接着子线程循环10次、主线程循环20次、反复进行50次
 * 使用生产者消费者模型
 */
public class MainAndSub {
    private boolean flag = false;

    //子线程
    public synchronized void sub(){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程："+i);
        }
        flag = true;
        this.notifyAll();
    }
    //主线程
    public synchronized void main(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 20; i++) {
            System.out.println("主线程："+i);
        }
        flag = false;
        this.notifyAll();
    }

    public static void main(String[] args) {
        MainAndSub m = new MainAndSub();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                m.sub();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                m.main();
            }
        }).start();

    }
}
