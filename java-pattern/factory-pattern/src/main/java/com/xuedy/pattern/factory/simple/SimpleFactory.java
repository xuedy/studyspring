package com.xuedy.pattern.factory.simple;



import com.xuedy.pattern.factory.ICourse;
import com.xuedy.pattern.factory.JavaCourse;
import com.xuedy.pattern.factory.PythonCourse;

import java.lang.reflect.Constructor;

/*
 *
 * @Author xuedy
 * @Description 简单工厂模式，终结写法，也不能满足特殊需求
 * @Date 23:45 2019/12/10
 **/
public class SimpleFactory {
    /*
     *
     * @Author xuedy
     * @Description
     * 根据传入的课程名称来决定是否要创建课程，
     * 1.需要调用者知道工厂能创建哪些类，
     * 2.需要调用者知道且调用参数的枚举，一旦参数错误就会返回null
     * 3.扩展的时候必须修改原来的代码
     * @Date 23:45 2019/12/10
     * @Param [courseName]
     * @return com.xuedy.pattern.factory.simple.ICourse
     **/
   public ICourse createCourse(String courseName){
       // 初级写法 字符串，需要用户记枚举参数
       if("java".equals(courseName)){
           System.out.println("courseName:"+courseName+"====》正在创建");
           return new JavaCourse();
       }else if("python".equals(courseName)){
           System.out.println("courseName:"+courseName+"====》正在创建");
           return new PythonCourse();
       }
       System.out.println("courseName:"+courseName+"输入有误");
       return null;
   }
   /*
    *
    * @Author xuedy
    * @Description  根据传入的类名来决定要创建的课程，
    * 1.调用者可以去代码拷贝想要的类
    * 2.一旦参数错误就会返回异常，如参数错误强转异常，如类不存在
    * 3.扩展的时候必不必改工厂原来的代码，只需要添加要实现的类
    * @Date 0:33 2019/12/11
    * @Param [className]
    * @return com.xuedy.pattern.factory.simple.ICourse
    **/
    public ICourse createCourseBetter(String  className){
        // 初级写法 低级反射，需要用户记查找类全称
        if(!(className==null||"".equals(className))){
            try {
                System.out.println("className:"+className+"====》正在创建");
                Class clazz=Class.forName(className);
                Constructor constructor=clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                ICourse course= (ICourse) constructor.newInstance();
                return course;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("className:"+className+"输入有误");
        return null;
    }
    /*
     *
     * @Author xuedy
     * @Description  根据传入的类来决定要创建的课程，
     * 1.调用者直接用想要的类  .class 就可以
     * 2.参数错误强转异常
     * 3.扩展的时候必不必改工厂原来的代码，只需要添加要实现的类
     * @Date 0:35 2019/12/11
     * @Param [clazz]
     * @return com.xuedy.pattern.factory.simple.ICourse
     **/
    public ICourse createCourseBest(Class clazz){
        //高级写法 利用反射
        if(clazz!=null){
            try {
                System.out.println("Class:"+clazz.getName()+"====》正在创建");
                Constructor constructor=clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                ICourse course= (ICourse) constructor.newInstance();
                return course;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Class:"+clazz.getName()+"输入有误");
        return null;
    }

    /*
     *
     * @Author xuedy
     * @Description  根据传入的类来决定要创建的对象，
     * 1.调用者直接用想要的类  .class 就可以
     * 2.参数错误强转异常
     * 3.扩展的时候必不必改工厂原来的代码，只需要添加要实现的类
     * 4.虽然已经很优化了，但是如有只有带构造参数呢？
     * @Date 0:35 2019/12/11
     * @Param [clazz]
     * @return com.xuedy.pattern.factory.simple.ICourse
     **/
    public Object createObjectEnded(Class clazz){
        //高级写法 利用反射
        if(clazz!=null){
            try {
                System.out.println("Class:"+clazz.getName()+"====》正在创建");
                Constructor constructor=clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                Object o= constructor.newInstance();
                return o;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Class:"+clazz.getName()+"输入有误");
        return null;
    }
}
