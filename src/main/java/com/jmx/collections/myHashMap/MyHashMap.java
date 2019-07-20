package com.jmx.collections.myHashMap;

import sun.awt.SunHints;

import java.awt.image.Kernel;
import java.util.Arrays;

/**
 * 我的简单HashMap实现
 *  * 1. 原理底层，hashcode---hash----segment----linked
 *  * 2. 实现put方法
 *  * 3. 实现get方法
 *  链表长度如果为8或以上，变为红黑树的数据结构
 * 如果是concurrentHashMap，则采用1.7的分段锁的思想，分段去锁，减低锁的粒度，提高并发能力
 * @author jmx
 * @create 2019-07-19-18:03
 */

public class MyHashMap<K,V> {

    //底层为位桶数组
    Node[] table;
    //map的大小
    int size;

    //构造函数
    public MyHashMap() {
        this.table = new Node[16];
    }

    //hash算法，通过hashcode获取hash值，放入table数组中
    public static int myhash(int hashCode, int length){
        //取模
        int hash = hashCode & (length - 1);
        System.out.println("hash值是："+hash);
        return hash;  //只要长度为2的整数次幂，按位与的效果与取模算法一样
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }

    /**
     * 思路：1. 计算hashcode，再得到hash,构建Node放入
     * 2. 根据hash放入对应位置的位桶数组中
     * 3. 查看是否有hash冲突，如果没有冲突直接放入数组中
     * 4. 如果有冲突。查看key是否有重复，如果重复则覆盖该node，如果没有则放在最后
     * @param k
     * @param v
     * @return
     */
    public void put(K k, V v){
        boolean keyRepeat = false;
        //计算hash值
        int hash = myhash(k.hashCode(), table.length);
        //构建Node
        Node node = new Node();
        node.setNext(null);
        node.setV(v);
        node.setK(k);
        node.setHash(hash);

        //是否冲突hash
        Node temp = table[hash];
        Node iterLast = null;

        if(temp==null){
            table[hash] = node;
        }else{
            //hash冲突,是否发送key冲突
            while(temp!=null){
                if(temp.getK().equals(k)){
                    keyRepeat = true;
                    temp.setV(v);
                    break;
                }else {
                    //key不重复，则遍历下一个，直至最后一个node
                    iterLast = temp;
                    temp = temp.getNext();
                }
            }
            //key不冲突，添加到最后一个中
            if(!keyRepeat){
                iterLast.setNext(node);
            }
        }
    }

    /**
     * 通过key去获取value
     * @param k
     * @return
     */
    public V get(K k){
        //1. hash定义table位置
        int hash = myhash(k.hashCode(), table.length);
        //2. 查看头节点是否匹配
        Node<K,V> node = table[hash];
        V v = null;
        //3. 遍历所有节点获取数据
        if (node != null) {
            //遍历查找
            while(node!=null){
                if(node.getK().equals(k)){
                    //赋值返回
                    v = node.getV();
                    break;
                }else {
                    node = node.getNext();
                }
            }
        }
        return v;
    }
}
