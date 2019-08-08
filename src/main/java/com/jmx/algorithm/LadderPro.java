package com.jmx.algorithm;

/**
 * 阶梯问题
 * 爱因斯坦曾出过这样一道有趣的数学题：有一个长阶梯，每步上2阶，最后剩1阶；若每步上3阶，
 * 最后剩2阶；若每步上5阶，最后剩4阶；若每步上6阶，最后剩5阶；只有每步上7阶，最后一阶也不剩。请问该阶梯至少有多少阶?
 *
 * 解题思路：
 * 量化题目为x%2=1;
 * x%3=2;
 * x%5=4;
 * x%6=5;
 * x%7=0
 * 求x的最小值，因此用7的倍数依次与2，3，5，6取模运算即可
 */
public class LadderPro {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if(i%2==1 && i%3==2 && i%5==4 && i%6==5 && i%7==0){
                System.out.println(i);
                break;
            }
        }
    }

    //将数字倒叙输出
    public static int reverseNum(int n){
        int revNum = 0;
        while(n!=0){
            revNum = n%10 + revNum*10;
            n /= 10;
        }
        return revNum;
    }
}
