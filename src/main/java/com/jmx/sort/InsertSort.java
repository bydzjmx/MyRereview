package com.jmx.sort;

import java.util.Arrays;

/**
 * 插入排序的实现
 *
 * @author jmx
 * @create 2019-07-20-9:37
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,8,-5,3,99,-76,0,-51};
        //插入排序，假定前面的是有序数组，往前插入即可
        //外层循环控制往前插的数，内层循环控制插入的位置
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
