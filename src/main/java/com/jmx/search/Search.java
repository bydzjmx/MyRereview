package com.jmx.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 查找算法的java实现
 * 一、基于线性表的查找（具有索引和顺序）
 * 1. 顺序查找
 * 2. 折半查找（二分法）
 * 3. 分块查找
 * 二、比较式查找
 * 1. 二叉平衡树
 * 2. 平衡二叉树
 *  基于树的动态查找
 *  B-树，B+树
 * 三、计算式查找
 * 1. hash查找
 */

public class Search {
    public static void main(String[] args) {
        int[] num = new int[]{7,9,10,8,2,1,3,4,6,5,20,25,56,0,13,14,15};
        //        System.out.println(OrderSearch(num,2));
//        System.out.println(BinarSearch(num,2));
//        int index = BlockSearch(num,SplitBlock(num,3),0);
//        System.out.println(index);
        //构建二叉排序树
//        BinarySortTree b = new BinarySortTree();
//        b.val = 5;
//        b.left_child = new BinarySortTree();
//        b.right_child = new BinarySortTree();
//        b.left_child.val = 3;
//        b.right_child.val = 7;
//        b.left_child.left_child = new BinarySortTree();
//        b.left_child.right_child = new BinarySortTree();
//        b.left_child.left_child.val = 2;
//        b.left_child.right_child.val = 4;
//        b.right_child.left_child = new BinarySortTree();
//        b.right_child.right_child = new BinarySortTree();
//        b.right_child.left_child.val = 6;
//        b.right_child.right_child.val = 8;
//        SearchMethod search = new SearchMethod();
//        System.out.println(search.BinaryTreeSearch(b,9));
    }

    /** 1
     * 顺序查找:逐个比较，直到找到或者查找失败。
     * 时间复杂度可以表示O(h)=O(n)
     * 空间复杂度：S(n) = O(n)
     * @param arr 查找的数组
     * @param n 查找的数
     * @return 返回下标
     */
    public static int OrderSearch(int[] arr,int n){
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

    /** 2
     * 二分法查找:对于已经按照一定顺序排列好的列表，
     * 每次都用关键字和中间的元素对比，然后判断是在前部分还是后部分还是就是中间的元素，
     * 然后继续用关键字和中间的元素对比。
     * 时间复杂度可以表示O(h)=O(log2n)
     *
     * 即查找时分三种情况，value>arr[mid],在[mid+1,end]区间查找
     * @param arr 查找的数组
     * @param n 查找的数
     * @return 返回下标
     */
    public static int BinarySearch(int[] arr,int n){
        int low = 0;
        int high = arr.length -1;
        //借助while完成分治递归过程
        while (low < high) {
            int mid = (low+high)/2;
            int item = arr[mid];
            if (n > item) {
                low = mid+1;
            } else if (n < item) {
                high = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二叉排序树/B树查找
     * 时间复杂度：O(logn)
     * @param b 二叉排序树
     * @param n 查找值
     * @return 返回结果
     */

}
