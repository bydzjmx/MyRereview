package com.jmx.thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;

/**
 * 使用多线程模拟龟兔赛跑
 */
public class TurtleRabbitRace{

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建线程池管理线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        //创建乌龟和兔子对象
        Race tortoise = new Race("tortoise",1000);
        Race rabbit = new Race("rabbit",400);
        //运行线程获取值
        Future<Integer> result1 = service.submit(tortoise);
        Future<Integer> result2 = service.submit(rabbit);

        //结束线程
        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        //获取步数
        Integer num1 = result1.get();
        Integer num2 = result2.get();
        System.out.println("tortoise has run "+num1+"steps");
        System.out.println("rabbit has run "+num2+"steps");

        //停止线程运行
        service.shutdown();
    }

}

//选手类，call方法返回走了的步数
@Data
class Race implements Callable<Integer>{
    //选手名称
    private String name;
    //延迟时间（兔子先跑）,使用延迟控制跑的速度
    private long time;
    //控制循环的开始结束
    private boolean flag = true;
    //跑了的步数
    private int step = 0;

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);
            this.step++;
        }
        return step;
    }
}
