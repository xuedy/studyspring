package com.xuedy.pattern.factory.abstractfactory;

import com.xuedy.pattern.factory.*;

/**
 * @author Administrator
 * @className JavaFactory
 * @description TODO
 * @date {DATE}{TIME}
 */
public class JavaFactory implements IAbstractFactory{
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
