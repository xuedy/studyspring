package com.xuedy.pattern.factory.factorymethod;

import com.xuedy.pattern.factory.ICourse;

/**
 * @author Administrator
 * @className IFactoryMethod
 * @description 工厂方法模式，只关心你需要产品对应的工厂
 * @date {DATE}{TIME}
 */
public interface IFactoryMethod {
    Object createCourse();
}
