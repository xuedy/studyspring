package com.xuedy.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Administrator
 * @className TestThread
 * @description TODO
 * @date {DATE}{TIME}
 */
public class LazyTestThread implements  Runnable{

    @Override
    public void run() {
        LazySingleton lazySingleton =LazySingleton.getInstance();
            System.out.println("线程名称"+Thread.currentThread().getName()+"对象2"+lazySingleton);
    }
}
