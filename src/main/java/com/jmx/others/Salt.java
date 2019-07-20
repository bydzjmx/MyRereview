package com.jmx.others;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author jmx
 * @create 2019-07-20-9:28
 */
public class Salt {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString();
        String[] split = s.split("-");
        List<String> strings = Arrays.asList(split);
        System.out.println(s);
        System.out.println(strings);
    }
}
