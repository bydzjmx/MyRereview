package com.jmx.designPattern.staticProxy;

/**
 * 安卓实现类，可以实现相关的功能
 */
public class AndroidMobilePhone implements MobilePhone{
     private String name;
     private String age;

    public AndroidMobilePhone(String name, String age) {
        this.name = name;
        this.age = age;
    }
    //打电话给jack
    @Override
    public void callJack(){
         System.out.println(" hey boy! name="+name+",age="+age);
    }
}