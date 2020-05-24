package com.xuedy.pattern.factory.abstractfactory;

import com.xuedy.pattern.factory.ICourse;
import com.xuedy.pattern.factory.INote;
import com.xuedy.pattern.factory.IVideo;

/**
 * @author Administrator
 * @className AbstratFactoryTest
 * @description TODO
 * @date {DATE}{TIME}
 */
public class AbstratFactoryTest {
    public static void main(String[] args) {
         IAbstractFactory iAbstractFactory= new JavaFactory();
        ICourse javaCourse= iAbstractFactory.createCourse();
        INote javaNote =iAbstractFactory.createNote();
        IVideo javaVideo= iAbstractFactory.createVideo();
        System.out.println("ICourse:"+javaCourse);
        System.out.println("INote:"+javaNote);
        System.out.println("IVideo:"+javaVideo);
    }
}
