package com.jmx.designPattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 非共享享元类，坐标（外部状态）
 */
@Data
@AllArgsConstructor
public class Coordinate {
    private int x,y;
}
