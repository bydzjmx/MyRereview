package com.jmx.algorithm;

import java.util.Stack;

/**
 * 字符串反转的方法
 */
public class StringReverse {
    /**
     * 二分递归,递归分治的思想
     * @param s
     * @return
     */
    public static String reverse1(String s){
        int length = s.length();
        if(length<=1){
            return s;
        }
        String left = s.substring(0,length/2);
        String right = s.substring(length/2,length);
        return reverse1(right)+reverse1(left);
    }

    /**
     *取得当前字符并使用往前添加的方法
     */
    public static String reverse2(String s){
        String reverse ="";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            reverse = s.charAt(i) + reverse;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse1("Jiang Mingxiang"));
        System.out.println(reverse2("Jiang Mingxiang"));
        System.out.println(reverse3("Jiang Mingxiang"));
        System.out.println(reverse4("Jiang Mingxiang"));
        System.out.println(reverse5("Jiang Mingxiang"));
        System.out.println(reverse6("Jiang Mingxiang"));
        System.out.println(reverse7("Jiang Mingxiang"));
        System.out.println(reverse8("Jiang Mingxiang"));
    }

    /**
     * 将字符从后面append起来
     */
    public static String reverse3(String s){
        char[] chars = s.toCharArray();
        String reverse = "";
        for (int i = chars.length-1; i >= 0 ; i--) {
            reverse += chars[i];
        }
        return reverse;
    }

    /**
     * 使用StringBuilder的reverse方法
     */
    public static String reverse4(String s){
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * 使用StringBuffer的reverse方法
     */
    public static String reverse5(String s){
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * 使用二分交换,将左右的数进行交换
     */
    public static String reverse6(String s){
        char[] arr = s.toCharArray();
        int length = s.length();
        int end = length -1;
        int half = end/2;
        for (int i = 0; i < half; i++) {
            char temp = arr[i];
            arr[i] = arr[end-i];
            arr[end-i] = temp;
        }
        return new String(arr);
    }

    /**
     * 原理是使用异或交换字符串
     * a=a^b;
     * b=b^a;
     * a=b^a;
     *
     * @param s
     * @return
     */
    public static String reverse7(String s) {
        char[] array = s.toCharArray();
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            array[begin] = (char) (array[begin] ^ array[end]);
            array[end] = (char) (array[end] ^ array[begin]);
            array[begin] = (char) (array[end] ^ array[begin]);
            begin++;
            end--;
        }
        return new String(array);
    }

    /**
     * 使用栈后进先出
     */
    public static String reverse8(String s){
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        //入栈
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        //出栈
        String reverse = "";
        for (int i = 0; i <array.length; i++) {
            reverse += stack.pop();
        }
        return reverse;
    }
}
