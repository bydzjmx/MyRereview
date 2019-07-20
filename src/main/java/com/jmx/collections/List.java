package com.jmx.collections;

/**
 * 定义所有集合的接口，设计与规范，定义响应的规范
 */
public interface List<E> {

    //长度
    int size();
    //增加到末尾
    void add(E e);
    //插入到指定位置
    void add(int i,E e);
    //删除
    void delete(E e);
    //删除指定位置
    void delete(int i);
    //按照索引获取对应的对象
    Object get(int i);
    //获取指定对象的位置
    int getIndex(E e);
}
