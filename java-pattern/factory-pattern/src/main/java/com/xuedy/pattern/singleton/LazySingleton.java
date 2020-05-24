package com.xuedy.pattern.singleton;

import com.sun.jndi.toolkit.dir.LazySearchEnumerationImpl;

/**
 * @author Administrator
 * @className LazySingleton
 * @description TODO
 * @date {DATE}{TIME}
 */
public class LazySingleton {
    private static LazySingleton lazySingleton=null;
    private LazySingleton(){

    }
    //1 添加synchronized 会造成类死锁
    public static LazySingleton getInstance(){
        if(lazySingleton==null){
            synchronized (lazySingleton){
                if(lazySingleton==null){
                    lazySingleton=new LazySingleton();
                }

            }

        }
        return lazySingleton;
    }
}
