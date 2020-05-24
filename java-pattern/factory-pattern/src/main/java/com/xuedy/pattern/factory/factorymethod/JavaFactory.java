package com.xuedy.pattern.factory.factorymethod;

import com.xuedy.pattern.factory.ICourse;
import com.xuedy.pattern.factory.JavaCourse;

/**
 * @author Administrator
 * @className JavaFactory
 * @description TODO
 * @date {DATE}{TIME}
 */
public class JavaFactory implements IFactoryMethod{
    @Override
    public ICourse createCourse() {
        System.out.println("java 工厂方法");
        return new JavaCourse();
    }
}
