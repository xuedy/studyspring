package com.xuedy.pattern.singleton;

/**
 * @author Administrator
 * @className LazySingleton
 * @description TODO
 * @date {DATE}{TIME}
 */
public class LazySingletonBetter {

    private LazySingletonBetter(){

    }
    //1 添加synchronized 会造成类死锁
    public static LazySingletonBetter getInstance(){
        return InnerClass.lazySingleton;
    }
    private static  final  class InnerClass{
        private static final LazySingletonBetter lazySingleton=new LazySingletonBetter();
    }
}
