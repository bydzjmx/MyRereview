package com.jmx.algorithm;

import java.util.Scanner;

/**
 * 截取字符串
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串
 * 1.需保证汉字不被截断,截不全的舍去（汉字为2个字节GBK,UTF下为3个字节，英文字符占1个字节）
 * 2.汉字的ASCII码均为负数
 */
public class SubString {
    /**
     * 截取字符串
     * @param str 待截取的字符串
     * @param num 截取长度
     * @return
     */
    public static String subStr(String str,int num){
        //前置判断
        if(null == str || str.length()==0 || num <=0){
            return "";
        }
       int length = str.length(),sum=0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            //将每个字符转成字符串
            String temp = String.valueOf(str.charAt(i));
            // 汉字转换成byte数组后,长度大于1,且字节数组内的值均小于0
            int tempLen = temp.getBytes().length;
            sum+=tempLen;
            //如果长度超过限制，跳出循环
            if (sum > num) {
                break;
            }
            //加入到sb中，如果要求的截不全的也
            sb.append(temp);
        }
        //返回
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = subStr("我爱你呀71", 13);
        System.out.println(test);
    }
}
