package com.xuedy.pattern.singleton;

/**
 * @author Administrator
 * @className HungrySingletonTest
 * @description TODO
 * @date {DATE}{TIME}
 */
public class HungrySingletonTest {
    public static void main(String[] args) {
        Thread thread1= new Thread(new HungryTestThread());
        Thread thread2= new Thread(new HungryTestThread());
        Thread thread3= new Thread(new HungryTestThread());
        Thread thread4= new Thread(new HungryTestThread());
        Thread thread5= new Thread(new HungryTestThread());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }
}
