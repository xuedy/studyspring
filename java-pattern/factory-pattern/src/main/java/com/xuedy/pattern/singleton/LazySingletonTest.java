package com.xuedy.pattern.singleton;

/**
 * @author Administrator
 * @className HungrySingletonTest
 * @description TODO
 * @date {DATE}{TIME}
 */
public class LazySingletonTest {
    public static void main(String[] args) {

        Thread thread1= new Thread(new LazyTestThread());
        Thread thread2= new Thread(new LazyTestThread());
        Thread thread3= new Thread(new LazyTestThread());
        Thread thread4= new Thread(new LazyTestThread());
        Thread thread5= new Thread(new LazyTestThread());
        Thread thread6= new Thread(new LazyTestThread());
        Thread thread7= new Thread(new LazyTestThread());
        Thread thread8= new Thread(new LazyTestThread());
        Thread thread9= new Thread(new LazyTestThread());
        Thread thread10= new Thread(new LazyTestThread());
        Thread thread11= new Thread(new LazyTestThread());
        Thread thread12= new Thread(new LazyTestThread());
        Thread thread13= new Thread(new LazyTestThread());
        Thread thread14= new Thread(new LazyTestThread());
        Thread thread15= new Thread(new LazyTestThread());
        Thread thread16= new Thread(new LazyTestThread());
        Thread thread17= new Thread(new LazyTestThread());
        Thread thread18= new Thread(new LazyTestThread());
        Thread thread19= new Thread(new LazyTestThread());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
        thread11.start();
        thread12.start();
        thread13.start();
        thread14.start();
        thread15.start();
        thread16.start();
        thread17.start();
        thread18.start();
        thread19.start();




    }
}
