package com.jmx.collections.myStack;

/**
 * 手写栈,通过数组实现
 */
public class MyStack {
    private long[] arr;
    int top;
    int size;
    int capacity;

    public MyStack() {
        this.arr = new long[10];
        //代表空栈
        this.top = -1;
        this.capacity = 10;
        size =0;
    }

    public MyStack(int initCapacity) {
        this.arr = new long[initCapacity];
        this.top = -1;
        this.capacity = initCapacity;
        size =0;
    }

    //添加数据
    public void push(long value){
        arr[++top] = value;
        size++;
    }
    //移除数据
    public long pop(){
        return arr[top--];
    }
    //查看数据
    public long peek(){
        return arr[top];
    }
    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //判断是否满了
    public boolean isFull(){
        return size == arr.length -1;
    }
}
