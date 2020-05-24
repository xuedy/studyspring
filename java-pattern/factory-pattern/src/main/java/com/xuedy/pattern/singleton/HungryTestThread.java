package com.xuedy.pattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.sql.SQLOutput;

/**
 * @author Administrator
 * @className TestThread
 * @description TODO
 * @date {DATE}{TIME}
 */
public class HungryTestThread implements  Runnable{

    @Override
    public void run() {
        //HungrySingleTon hungrySingleTon=HungrySingleTon.getInstance();
        try {
//            Constructor constructor= HungrySingleTon.class.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            HungrySingleTon hungrySingleTon= (HungrySingleTon) constructor.newInstance();
            HungrySingleTon hungrySingleTon= HungrySingleTon.getInstance();
            HungrySingleTon hungrySingleTon1=null;
            FileOutputStream fos=new FileOutputStream("hungrySingleTon.obj");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fos);
            objectOutputStream.writeObject(hungrySingleTon);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream=new FileInputStream("hungrySingleTon.obj");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            hungrySingleTon1= (HungrySingleTon) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("线程名称"+Thread.currentThread().getName()+"对象1"+hungrySingleTon);
            System.out.println("线程名称"+Thread.currentThread().getName()+"对象2"+hungrySingleTon1);
            System.out.println(hungrySingleTon==hungrySingleTon1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
