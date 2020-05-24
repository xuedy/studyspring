package com.xuedy.pattern.singleton;

/**
 * @author Administrator
 * @className HungrySingleTonBetter
 * @description TODO
 * @date {DATE}{TIME}
 */
public class HungrySingleTonBetter {

    private static final HungrySingleTonBetter hungrySingleTonBetter;
    static{
        hungrySingleTonBetter=new HungrySingleTonBetter();
    }

    private HungrySingleTonBetter (){
        //防止反射
        if(hungrySingleTonBetter!=null){
           throw  new RuntimeException("实例已经创建，不允许重复创建") ;
        }
    }

    public static HungrySingleTonBetter getInstance(){
        return hungrySingleTonBetter;
    }
}
