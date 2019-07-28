package com.jmx.sort;

import java.util.Arrays;

/**
 * 冒泡排序的实现
 *
 * @author jmx
 * @create 2019-07-20-9:37
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,8,-5,3,99,-76,0};
        //外层循环控制循环总次数 , 0-1,1-2,2-3
        //内层循环控制每次循环的次数 , 0-1, 1-2 ; 0-1
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    //交换位置
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
