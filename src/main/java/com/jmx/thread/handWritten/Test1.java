package com.jmx.thread.handWritten;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 数组A为1,2,3,4,5,6,...52
 * 数组B为 26个英文字母
 * 用两个线程分别输出12a23b....
 *
 * 可以使用自旋锁, lockSupport ,  以下使用 自旋锁即CAS实现
 * 使用Atomic类
 */

public class Test1 {
    public static void main(String[] args) {
        //使用AtomicBoolean进行标志位，多线程共享，可以保证并发状态下的安全
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11};
        String[] words = {"a","b","c","d","e"};
        new printNums(nums,atomicBoolean).start();
        new printWords(words,atomicBoolean).start();
    }

    //输出数字的线程
    static class printNums extends Thread{
        private int[] nums;
        private AtomicBoolean isNum;

        public printNums(int[] nums,AtomicBoolean isNum){
            this.nums = nums;
            this.isNum = isNum;
        }

        //循环输出数字
        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                while (!isNum.get()){
                    //如果输出了2个数字，将isNum设置为false，将线程从运行状态修改为就绪状态
                    Thread.yield();
                }
                System.out.print(nums[i]);
                if(++count==2){
                    isNum.set(false);
                    count=0;
                }
            }
            isNum.set(false);
        }
    }

    //输出数字的线程
    static class printWords extends Thread{
        private String[] words;
        private AtomicBoolean isWord;

        public printWords(String[] words,AtomicBoolean isWord){
            this.words = words;
            this.isWord = isWord;
        }

        //循环输出英文单词
        @Override
        public void run() {
            int count = 0;
            for (int i = 0; i < words.length; i++) {
                while (isWord.get()){
                    yield();
                }
                System.out.print(words[i]);
                if(++count==1){
                    isWord.set(true);
                    count=0;
                }
            }
            isWord.set(true);
        }
    }
}
