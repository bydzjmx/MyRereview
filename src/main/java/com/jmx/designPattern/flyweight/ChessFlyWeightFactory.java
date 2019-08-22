package com.jmx.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 */
public class ChessFlyWeightFactory {
    //享元池对象，所有内容从池中取
    public static Map<String,ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color){
        if(map.get(color)!=null){
            return map.get(color);
        }else {
            ChessFlyWeight cfw = new ConcreteFlyWeight(color);
            map.put(color,cfw);
            return cfw;
        }
    }
}
