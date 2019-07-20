package com.jmx.collections.myArraylist;

import java.util.ArrayList;

/**
 * @author jmx
 * @create 2019-07-15-0:19
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("123");
        list.add("呵呵呵");
        list.add("哦哦");
        list.add("哈哈哈");
        System.out.println(list);
        list.add(1,"你好");
        System.out.println(list);
        //System.out.println(list.isEmpty());
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list.set(2, "你好啊"));   //返回旧值
        System.out.println(list.get(2));
    }
}
