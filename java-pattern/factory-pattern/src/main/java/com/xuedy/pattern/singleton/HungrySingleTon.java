package com.xuedy.pattern.singleton;

import javax.servlet.http.HttpUpgradeHandler;
import java.io.Serializable;

/**
 * @author Administrator
 * @className HuangarySingleTon
 * @description 饿汉式单利
 * @date {DATE}{TIME}
 */
public class HungrySingleTon implements Serializable {

    private static final HungrySingleTon hungrySingleTon=new HungrySingleTon();

    private HungrySingleTon(){
        if(hungrySingleTon!=null){
            throw  new RuntimeException("实例已经创建，不允许重复创建") ;
        }
    }

    public static HungrySingleTon getInstance(){
        return hungrySingleTon;
    }
    private Object  readResolve(){
        return hungrySingleTon;
    }
}
