package com.jmx.designPattern.flyweight;

public class Test {
    public static void main(String[] args) {
        //取出黑色棋子
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");
        //chess1==chess2
        System.out.println(chess1);
        System.out.println(chess2);

        //加上外部状态，使用同一对象，改变chess的坐标
        System.out.println("增加外部状态的处理=======");
        chess1.disPlay(new Coordinate(10,10));
        chess2.disPlay(new Coordinate(20,20));

    }
}
