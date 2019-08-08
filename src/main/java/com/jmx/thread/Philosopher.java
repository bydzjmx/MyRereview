package com.jmx.thread;

/**
 * 哲学家进餐问题
 * 一圆桌前坐着5位哲学家，两个人中间有一只筷子，桌子中央有面条。哲学家思考问题，当饿了的时候拿起左右两只筷子吃饭，
 * 必须拿到两只筷子才能吃饭。上当5个哲学家都拿起自己右手边的筷子，准备拿左手边的筷子时产生死锁现象。
 *
 * 解决思路： 只有当左右两只手的筷子都能获取时，才拿起筷子，然后同时放下两只筷子
 * 使用boolean标记筷子的拿起情况
 * 每个哲学家相当于一个线程,具有名字和筷子属性
 *
 * 目标：可以看到最多只能有两条相邻的eating结果，因为每个时刻最多能够满足两个人同时进餐，且两人座位不相邻
 */
public class Philosopher extends Thread{
    private String name;
    private Fork fork;

    public Philosopher(String name,Fork fork){
        this.name = name;
        this.fork = fork;
    }

    @Override
    public void run() {
        while(true){
            thinking();
            fork.takeFork();
            eating();
            fork.putFork();
        }
    }

    private void eating() {
        System.out.println("I am Eating:"+name);
        //模拟吃饭，占用一段时间资源
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void thinking() {
        System.out.println("I am Thinking:"+name);
        //模拟思考
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Fork fork = new Fork();
        new Philosopher("0",fork).start();
        new Philosopher("1",fork).start();
        new Philosopher("2",fork).start();
        new Philosopher("3",fork).start();
        new Philosopher("4",fork).start();
    }
}

class Fork{
    //定义五个筷子的数组，标记其使用情况
    private boolean[] used = {false, false, false, false, false};

    //定义拿筷子的方法,只有当左右手的筷子都未被使用时，才允许获取筷子，且必须同时获取左右手筷子
    public synchronized void takeFork(){
        //获取当前线程信息
        String nameGet = Thread.currentThread().getName();
        String name = nameGet.substring(nameGet.length() - 1, nameGet.length());
        int i = Integer.parseInt(name);
        //只有当左右手的筷子都未被使用时，才允许获取筷子
        while (used[i] || used[(i+1)%5]){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //可以获取筷子
        used[i] = true;
        used[(i+1)%5] = true;
    }

    //定义放筷子的方法，同时放两个筷子
    public synchronized void putFork(){
        String nameGet = Thread.currentThread().getName();
        String name = nameGet.substring(nameGet.length() - 1, nameGet.length());
        int i = Integer.parseInt(name);
        used[i] = false;
        used[(i+1)%5] = false;
        //唤醒其他线程
        this.notifyAll();
    }
}