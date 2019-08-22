package com.jmx.designPattern.flyweight;

import lombok.AllArgsConstructor;

/**
 * 具体享元类
 */
@AllArgsConstructor
public class ConcreteFlyWeight implements ChessFlyWeight{
    //使用变量存储内部状态
    private String color;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void disPlay(Coordinate c) {
        System.out.println("棋子颜色："+color);
        System.out.println("棋子位置： "+c.getX()+"-------- "+c.getY());
    }
}
