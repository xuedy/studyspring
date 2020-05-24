package com.xuedy.pattern.factory.factorymethod;

import com.xuedy.pattern.factory.ICourse;
import com.xuedy.pattern.factory.JavaCourse;
import com.xuedy.pattern.factory.PythonCourse;

/**
 * @author Administrator
 * @className JavaFactory
 * @description TODO
 * @date {DATE}{TIME}
 */
public class PythonFactory implements IFactoryMethod{
    @Override
    public ICourse createCourse() {
        System.out.println("python 工厂方法");
        return new PythonCourse();
    }
}
