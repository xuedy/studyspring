package com.xuedy.pattern.factory.factorymethod;

import com.xuedy.pattern.factory.ICourse;

/**
 * @author Administrator
 * @className FactoryMethodTest
 * @description TODO
 * @date {DATE}{TIME}
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        JavaFactory javaFactory=new JavaFactory();
        ICourse javaCourse=javaFactory.createCourse();
        javaCourse.getCourse();

        PythonFactory pythonFactory= new PythonFactory();
        ICourse pythonCourse=pythonFactory.createCourse();
        pythonCourse.getCourse();
    }
}
