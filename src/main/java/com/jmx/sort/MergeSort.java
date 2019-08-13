package com.jmx.sort;

/**
 * 归并排序
 * 1. 核心也是利用分治和递归的技术将数组划分为半字表，将其排序后，合并为排好序的序列
 * 2. 核心步骤：1、划分半字表   2、合并半子表
 * 3. 对于给定的一组记录（假设有n个记录），首先将每两个相邻的长度为1的子序列进行归并，
 * 得到n/2(向上取整)个长度为2或者1的有序子序列，再将其两两归并，反复执行此过程，直到得到一个有序序列。
 * 4. 通过左右两个指针的移动进行排序
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }
}
