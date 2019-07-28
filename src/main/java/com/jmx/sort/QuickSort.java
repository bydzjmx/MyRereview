package com.jmx.sort;

import java.util.Arrays;

/**
 * 快速排序的实现， 是冒泡的优化版
 * 核心思想： 选定基准+分治+递归，利用双指针进行位移 i j k
 * 1. 从数列中取出一个数作为基准数
 * 2. 分区过程，将比这个数大的全放到它的右边，小于它的全部放到它的左边
 * 3. 递归过程，对左右区间重复第二部，直至每个区间剩下一个数
 * @author jmx
 * @create 2019-07-20-9:37
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,8,-5,3,99,-76,0,-51,3};
        //int[] arr = {2,5,0,4,3};
        //输出无序数组
        System.out.println("交换前的顺序: "+ Arrays.toString(arr));
        //进行快速排序
        quickSort(arr);
        //输出有序数组
        System.out.println("交换后的顺序: "+ Arrays.toString(arr));
    }

    /**
     * 传入数组，进行快速排序
     * 传入左指针，右指针，进行快排
     * @param arr
     */
    public static void quickSort(int[] arr){
        //左指针
        int low = 0 ;
        //右指针
        int high = arr.length -1;
        //进行快排
        quickSort(arr,low,high);
    }

    private static void quickSort(int[] arr, int low, int high) {
        //给定递归的结束条件
        if (low < high) {
            //进行分区，确立左分区和右分区,返回分界的索引，即i=j的点
            int index = partition(arr,low,high);
            //对左分区进行快排
            quickSort(arr,low,index-1);
            //对右分区进行快排
            quickSort(arr,index+1,high);
        }
    }

    /**
     * 分区方法
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        //指定左指针和右指针
        int i = low;
        int j = high;
        //将第一个数作为基准数，进行挖坑，赋值为x
        int x = arr[i];
        //进行分区过程，首先右指针从右往左找
        System.out.println(Arrays.toString(arr)+"开始分区,i,j分别为:"+i+"和"+j);
        while (i < j) {
            while (arr[j] > x && i < j) {
                j--;
                System.out.println("j减1,"+"j为"+j);
            }
            //找到了第一个小于等于x的数字，换位置
            if (i < j) {
                System.out.println("找到一个数，开始交换");
                arr[i] = arr[j];
                //此时可以理解为j位置被挖空，需要填充数
                System.out.println("第一次交换后"+Arrays.toString(arr));
                i++;
                System.out.println("i+1,"+"i为"+i);

            }
            //然后从左往右找，找到第一个比x大的数，填坑，右指针减1，完成分区操作
            while (arr[i] < x && i < j) {
                i++;
                System.out.println("i+1,"+"i为"+i);
            }
            //找到了第一个大于等于x的数字，换位置
            if(i<j){
                arr[j] = arr[i];
                j--;
                System.out.println("第二次交换后"+Arrays.toString(arr));
            }
        }
        //当左指针等于右指针，表示分区结束，将原有值放入该位置
        System.out.println("完成分区"+i+","+j);
        arr[j] = x;
        System.out.println(Arrays.toString(arr));
        return i;
    }
}
