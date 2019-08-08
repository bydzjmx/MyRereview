package com.jmx.algorithm;

/**
 * 排序快速手写
 */
public class SortTest {
    private static int[] arr = {1, -99, 80, -40};
    private static int length = arr.length;

    //冒泡
    public static int[] bubble(){
        //依次找出最大值，次大值，即0-1,1-2,2-3,0-1,1-2,0-1
        //外层控制次数，内从控制循环到的点
        for (int i = 0; i < length-1; i++) {
            for (int j = 0; j < length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    //选择排序，原理为先选出最小值，次小值,0-1,0-2,0-3,1-2,1-3,2-3
    //外层控制比较的基准数，内层为与之比较的数
    public static int[] insert(){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                //交换位置
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //插入排序,选定1个基准数，将后面的数插入前面，前面的都是已经排好序的数组
    //外层控制移动的数，内层控制与之比较的数
    public static int[] insertSort(){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else {
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 快速排序，选定基准+分治+递归的应用，利用双指针移动，i j k
     * 1. 从数组中选定一个数作为基准数
     * 2. 分治，将比这个数更大的放到右区间，比这个数更小的数放到它的左区间
     * 3. 递归，对左右区间重复分治过程，直至每个区间的数为1
     */
    public static void quickSort(int[] array){
        //传入左指针和右指针，控制递归过程
        int low = 0;
        int high = array.length-1;
        quickSort(array,low,high);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            //分区，返回临界点index，即i=j的位置）
            int index = partition(array,low,high);
            //递归快排左分区和右分区
            quickSort(array,0,index-1);
            quickSort(array,index+1,high);
        }
    }

    //分区过程
    private static int partition(int[] array, int low, int high) {
        //1. 设定左右指针
        int i = low;
        int j = high;
        //2. 设定基准值
        int temp = arr[i];
        //3. 开始分区过程,先移动右指针,找到第一个比基准值小的数
        while(i<j){
            while(arr[j]>temp && i<j){
                j--;
            }
            //找到了第一个小于temp的值,交换位置
            if(i<j){
                arr[i] = arr[j];
                i++;
            }
            //从左往右找
            while(arr[i]>temp && i<j){
                i++;
            }
            if(i<j){
                //找到了第一个比temp大的数
                arr[j] = arr[i];
                j--;
            }
        }
        //当左指针等于右指针，即完成分区，将值放到中间位置
        arr[i] = temp;
        return i;
    }

}
