package com.jmx.collections.myArraylist;

import com.jmx.collections.List;

import java.util.Arrays;

/**
 * ArrayList的实现
 * 底层是数组，对数组进行增删改查CRUD
 * this一般可省略，但是加上防止混淆
 * @author jmx
 * @create 2019-07-13-11:24
 */
public class MyArrayList<E> implements List<E> {

    //定义默认的容量
    private static final int DEFAULT_CAPACITY = 10;

    //底层是数组Array
    private Object[] data;

    int size;

    //构造方法
    public MyArrayList(int size) {
        //对size做判断
        if(size<1){
            throw new RuntimeException("初始容量不能为0负数");
        }else{
            this.data = new Object[size];
        }
    }

    //空参构造方法
    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    //校验容量是否合格，参数为需要添加的位置，如添加到最后则为size+1；
    private void ensureCapacity(int miniCapacity){
        //size已经到达最大，需要扩容，其他情况暂不考虑，因为一次添加一个元素
        if(size == data.length){
            //扩容
            int oldLength = data.length;
            int newLength = oldLength>>1 + oldLength;
            if(newLength < miniCapacity){
                newLength = miniCapacity;
            }
            //数组拷贝
            data = Arrays.copyOf(data, newLength);
        }
    }

    /**
     * 所有的添加，都需要先验证容量是否合格
     * @param e
     */
    @Override
    public void add(E e) {
        //直接添加到末尾
        ensureCapacity(size + 1);
        data[size++] = e;
    }

    //对索引进行判断,判断是否超出界限
    public void checkIndex(int i){
        if(i<0 || i>size-1){
            throw new RuntimeException("索引越界"+i);
        }
    }

    //在指定位置插入元素，后续元素要后移
    // 1 2 4  size=3 ,在2 4 中间插入， i = 2 ,移位数为1, size -i;
    //在2位置插入元素，则原2位置以后的都要后移一位（数组拷贝）
    @Override
    public void add(int i, E e) {
        //对索引进行判断
        checkIndex(i);
        //对容量进行判断
        ensureCapacity(size+1);
        //插入到指定位置
        int numMoved = size - i;
        //1. 复制原有的数组
        System.arraycopy(data,i,data,i+1,size-i);
        //2. i处复制
        data[i] = e;
        size++;
    }

    /**
     * 删除指定元素，需遍历
     * @param e
     */
    @Override
    public void delete(E e) {
        if(e==null){
            for (int i = 0; i < size; i++) {
                if(data[i]==e){
                    delete(i);
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if(e.equals(data[i])){
                    delete(i);
                }
            }
        }
    }

    //根据索引删除对应的数据
    //1 2 3 4 删除3，移动一个4 ，size-2-1
    @Override
    public void delete(int i) {
        checkIndex(i);
        Object oldValue = get(i);
        //向前赋值
        int moveNum = size - i - 1;
        System.arraycopy(data,i+1,data,i,moveNum);
        //size减1，length不会减
        data[--size] = null;
    }

    @Override
    public Object get(int i) {
        checkIndex(i);
        return data[i];
    }

    @Override
    public int getIndex(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i]==e){
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
