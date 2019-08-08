package com.jmx.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 首位互换
 * 从键盘上输入10个整数，并将其放入一个一维数组中，然后将其前5个元素与后5个元素对换，即：
 * 第1个元素与第10个元素互换，第2个元素与第9个元素互换…第5个元素与第6个元素互换。
 * 分别输出数组原来各元素的值和对换后各元素的值。
 */
public class ExchangeDemo {
    public static int[] arr = new int[10];
    public static void main(String[] args) {
        print();
    }

    public static void print(){
        //获取键入的数组
        arr = write();
        //输入现有
        System.out.println("\n你输入的数组是:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //进行交换
        for (int i = 0; i < 5; i++) {
            int temp = arr[i];
            arr[i] = arr[9-i];
            arr[9-i] = temp;
        }
        System.out.println("\n交换后的数组是:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 获取控制台键入的10个数字为一维数组
     */
    public static int[] write(){
        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第"+(i+1)+"个数：");
            Scanner scanner = new Scanner(System.in);
            arr[i] =scanner.nextInt();
        }
        return arr;
    }
}
