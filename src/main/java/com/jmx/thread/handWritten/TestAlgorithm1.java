package com.jmx.thread.handWritten;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAlgorithm1 {
    /**
     * 数组A为1,2,3,4,5,6,...52
     * 数组B为 26个英文字母
     * 用两个线程分别输出12a23b....
     *
     * 可以使用自旋锁, lockSupport ,  以下使用 自旋锁
     */
 
    public static void main(String[] args){
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        char[] chars = {'a','b','c','d','e'};
        new printNums(nums,atomicBoolean).start();
        new printChart(chars,atomicBoolean).start();
    }
 
    static class printNums extends  Thread{
        private int[] nums;
        private AtomicBoolean isNum;
 
        public printNums(int[] nums ,AtomicBoolean isNum){
            this.nums = nums;
            this.isNum= isNum;
        }
 
        @Override
        public void run() {
            int count = 0;
            for (int i=0 ;i<nums.length ;i++){
                while (!isNum.get()){
                    //是当前线程从执行状态,变为就绪状态, cpu会从众多就绪状态中选择, 即当前线程有可能会在此执行
                    Thread.yield();
                }
                System.out.print(nums[i]);
                count++;
                if (count==2){
                    isNum.set(false);
                    count = 0;
                }
            }
            isNum.set(false);
        }
    }
 
    static  class printChart extends  Thread{
        private char[] chars;
        private AtomicBoolean isNum;
 
        public printChart(char[] chars, AtomicBoolean isNum) {
            this.chars = chars;
            this.isNum = isNum;
        }
 
        @Override
        public void run() {
            int count = 0;
            for (int i=0 ;i<chars.length ;i++){
                while (isNum.get()){
                    Thread.yield();
                }
                System.out.print(chars[i]);
                count++;
                if (count==1){
                    isNum.set(true);
                    count = 0;
                }
            }
            isNum.set(true);
        }
    }
 
}