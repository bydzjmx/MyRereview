package com.jmx.collections.myLinkedList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 节点类,每个节点的数据
 * 双向链表
 * @author jmx
 * @create 2019-07-15-0:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node {

     Node last;
     Node next;
     Object obj;


}
