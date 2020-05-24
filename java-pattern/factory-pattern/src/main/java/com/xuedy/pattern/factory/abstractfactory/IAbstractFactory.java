package com.xuedy.pattern.factory.abstractfactory;

import com.xuedy.pattern.factory.ICourse;
import com.xuedy.pattern.factory.INote;
import com.xuedy.pattern.factory.IVideo;

/**
 * @author Administrator
 * @className IAbstractFactory
 * @description TODO
 * @date {DATE}{TIME}
 */
public interface IAbstractFactory {
    ICourse createCourse();
    INote createNote();
    IVideo createVideo();
}
