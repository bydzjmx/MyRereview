package com.jmx.collections.myHashMap;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jmx
 * @create 2019-05-11-11:50
 */
public class Test {
    public static void main(String[] args) {
        MyHashMap<String,String> hashMap = new MyHashMap<>();
        hashMap.put("1","我");
        hashMap.put("2","爱");
        hashMap.put("3","你");
        hashMap.put("1","我和你");
        System.out.println(hashMap);
    }
}
