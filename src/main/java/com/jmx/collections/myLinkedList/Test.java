package com.jmx.collections.myLinkedList;

/**
 * @author jmx
 * @create 2019-07-19-17:57
 */
public class Test {
    public static void main(String[] args) {
        MyLinkedList<String> extLinkedList = new MyLinkedList<String>();
        extLinkedList.add("a");
        extLinkedList.add("b");
        extLinkedList.add("c");
        extLinkedList.add("d");
        System.out.println("########################################");
        System.out.println(extLinkedList.first.obj);
        System.out.println(extLinkedList.first.next.obj);
        System.out.println(extLinkedList.first.next.next.obj);
        System.out.println(extLinkedList.first.next.next.next.obj);
        System.out.println("########################################");
        // 其实从头查到尾,效率不高，查询算法：折半查找(二分法)
        for (int i = 0; i < extLinkedList.size; i++) {
            System.out.println(extLinkedList.get(i));
        }
        System.out.println("长度：" + extLinkedList.size());
        System.out.println("########################################");
        extLinkedList.add(3, "小盒子");
        for (int i = 0; i < extLinkedList.size; i++) {
            System.out.println(extLinkedList.get(i));
        }
        System.out.println("########################################");
        System.out.println("删除之前：" + extLinkedList.get(2));
        extLinkedList.delete(2);
        System.out.println("删除之后：" + extLinkedList.get(2));
        System.out.println("########################################");
    }
}
