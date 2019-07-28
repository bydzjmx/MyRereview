package com.jmx.sort;

import java.util.Arrays;

/**
 * 简单选择排序的实现
 *
 * @author jmx
 * @create 2019-07-20-9:37
 */
public class SimpleSelectSort {
    public static void main(String[] args) {
        int[] arr = {1,8,-5,3,99,-76,0,-51};
        //先确定最小的数，外层控制比较基准数，内层控制与之比较的数
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]>arr[j]){
                    //交换数值
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
