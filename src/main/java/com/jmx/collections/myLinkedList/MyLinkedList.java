package com.jmx.collections.myLinkedList;

import com.jmx.collections.List;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NodeCounterGenerator;

/**
 * 我的链接list
 *  * 1.指定对象实现结点的添加
 *  *  2.要对头结点判断是否为空，空的话将制定对象置为头结点
 *  *  3.不为空，则往last后增加结点（直接）
 *  *  4.重要：要将last置为结点
 *  *  5.size++
 * @author jmx
 * @create 2019-07-15-0:22
 */
public class MyLinkedList<E> implements List<E> {

     Node first;

     Node last;

     int size;

     int index = -1;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(E e) {
        Node node = new Node();
        //判断头节点是否为空
        if (first == null) {
            node.setNext(null);
            node.setLast(null);
            node.setObj(e);
            first = node;
            last = node;
        }else {
            //头节点有值，添加到末尾
            node.setLast(last);
            node.setNext(null);
            node.setObj(e);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    //对索引进行判断,判断是否超出界限
    public void checkIndex(int i){
        if(i<0 || i>size-1){
            throw new RuntimeException("索引越界"+i);
        }
    }

    @Override
    public void add(int i, E e) {
        checkIndex(i);
        //获取原位置的node，用于链接关系的修改
        Node temp = getNode(i);
        //修改前后关系
        Node pre = temp.getLast();
        //新的Node
        Node newNode = new Node();
        if(temp!=null){
            newNode.setObj(e);
            newNode.setLast(pre);
            newNode.setNext(temp);
            //原有node关系更换
            pre.setNext(newNode);
            temp.setLast(newNode);
        }else {
            //为空，添加为头节点
            add(e);
        }
        size++;
    }

    @Override
    public void delete(E e) {
        //获取索引位置
        int index = getIndex(e);
        delete(index);
    }

    /**
     * 删除指定索引的值
     * @param i
     */
    @Override
    public void delete(int i) {
        checkIndex(i);
        Node temp = getNode(i);
        //修改前后链表的关系
        if(temp!=null){
            temp.getLast().setNext(temp.getNext());
            temp.getNext().setLast(temp.getLast());
            size--;
        }
    }

    @Override
    public Object get(int i) {
        checkIndex(i);
        Node node = getNode(i);
        //实现节点的遍历
        if(node!=null){
            return node.getObj();
        }
        return null;
    }

    //返回指定索引的node
    public Node getNode(int index){
        checkIndex(index);
        Node node = null;
        //从头开始遍历
        if (first != null) {
            node = first;
        }
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }


    @Override
    public int getIndex(E e) {
        if(e==null){
            for(Node x = first;x!=null;x=x.getNext()){
                //记录索引
                index++;
                if(x.getObj()==null){
                    return index;
                }
            }
        }else {
            //e不为空
            for(Node x = first;x!=null;x=x.getNext()){
                index++;
                if(e.equals(x.getObj())){
                    return index;
                }
            }
        }
        return -1;
    }
}
