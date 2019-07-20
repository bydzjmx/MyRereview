package com.jmx.collections.myHashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jmx
 * @create 2019-07-19-18:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<K,V> {

    int hash;
    K k;
    V v;
    Node<K,V> next;
}
