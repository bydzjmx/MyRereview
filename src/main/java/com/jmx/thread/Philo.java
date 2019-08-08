package com.jmx.thread;

import javax.management.relation.RoleUnresolved;

/**
 * 只有左右都有筷子才能吃饭，每次放下为放下两个筷子
 * 面向对象，哲学家为对象（看成线程），筷子为对象
 */
public class Philo extends Thread{
    private String name;
    private Fork2 fork;

    public Philo(String name,Fork2 fork){
        this.name = name;
        this.fork = fork;
    }

    public void thinking(){
        System.out.println(name+":在思考");
        s(1000);
    }

    public void eating(){
        System.out.println(name+":在吃饭");
        s(1000);
    }

    @Override
    public void run() {
        while(true){
            thinking();
            fork.take();
            eating();
            fork.release();
        }
    }


     static void s(long time){
         try {
             Thread.sleep(time);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }

    public static void main(String[] args) {
        Fork2 fork = new Fork2();
        new Philo("0",fork).start();
        new Philo("1",fork).start();
        new Philo("2",fork).start();
        new Philo("3",fork).start();
        new Philo("4",fork).start();
    }
}

class Fork2 {
    private boolean[] used = {false,false,false,false,false};

    public synchronized void take() {
        String nameGet = Thread.currentThread().getName();
        String name = nameGet.substring(nameGet.length() - 1, nameGet.length());
        int i = Integer.parseInt(name);
        if(used[i] || used[(i+1)%5]){
            //无法获取筷子
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //已拿
        used[i] = true;
        used[(i+1)%5] = true;
    }

    public synchronized void release() {
        String nameGet = Thread.currentThread().getName();
        String name = nameGet.substring(nameGet.length() - 1, nameGet.length());
        int i = Integer.parseInt(name);
        //已拿
        used[i] = false;
        used[(i+1)%5] = false;
        this.notifyAll();
    }
}


