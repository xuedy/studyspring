package com.xuedy.pattern.factory.simple;

import com.xuedy.pattern.factory.CCourse;
import com.xuedy.pattern.factory.ICourse;
import com.xuedy.pattern.factory.JavaCourse;
import com.xuedy.pattern.factory.PythonCourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        System.out.println("简单工程模式它不属于23中设计模式(小作坊)，不符合职责单一原则");
        //初级写法 工厂类接收字符串参数
        System.out.println("\n初级写法,简单工程模式测试开始");
        SimpleFactory simpleFactory=new SimpleFactory();
        ICourse javaCourse=   simpleFactory.createCourse("java");
        javaCourse.getCourse();
        ICourse pythonCourse= simpleFactory.createCourse("python");
        pythonCourse.getCourse();
        //没有C课程会返回null 会产生NPE
        /*ICourse cCourse= simpleFactory.createCourse("c");
        cCourse.getCourse();*/
        System.out.println("初级写法,简单工程模式测试结束\n");
        //低级写法 利用Java反射机制 工厂类接className
        ICourse javaCourseBetter=   simpleFactory.createCourseBetter("com.xuedy.pattern.factory.JavaCourse");
        javaCourseBetter.getCourse();
        ICourse pythonCourseBetter= simpleFactory.createCourseBetter("com.xuedy.pattern.factory.PythonCourse");
        pythonCourseBetter.getCourse();
        ICourse cCourseBetter= simpleFactory.createCourseBetter("com.xuedy.pattern.factory.CCourse");
        cCourseBetter.getCourse();
        System.out.println("低级写法,简单工程模式测试结束\n");
        //高级写法 利用Java反射机制 工厂类接class
        System.out.println("\n高级写法,简单工程模式测试开始");
        ICourse javaCourseBest=   simpleFactory.createCourseBest(JavaCourse.class);
        javaCourseBest.getCourse();
        ICourse pythonCourseBest= simpleFactory.createCourseBest(PythonCourse.class);
        pythonCourseBest.getCourse();
        ICourse cCourseBest= simpleFactory.createCourseBest(CCourse.class);
        cCourseBest.getCourse();
        System.out.println("高级写法,简单工程模式测试结束\n");
        //终极写法 利用Java反射机制 工厂类接class
        System.out.println("\n终极写法,简单工程模式测试开始");
        ICourse javaCourseEnded=  (ICourse) simpleFactory.createObjectEnded(JavaCourse.class);
        javaCourseEnded.getCourse();
        ICourse pythonCourseEnded=(ICourse) simpleFactory.createObjectEnded(PythonCourse.class);
        pythonCourseEnded.getCourse();
        ICourse cCourseEnded= (ICourse)simpleFactory.createObjectEnded(CCourse.class);
        cCourseEnded.getCourse();
        System.out.println("终极写法,简单工程模式测试结束\n");

        System.out.println("javaCourseBest:"+javaCourseBest.getClass());
        System.out.println("javaCourseBes:"+pythonCourseBest.getClass());
        System.out.println("javaCourseBes:"+cCourseBest.getClass());
        /*
         * 思考：用工程模式有什么好处，目前来看，没有好处，反而更复杂了，多了一个工厂类
         * 1.如果创建比较复杂，如在创建之前做额外工作，创建后做对应修改
         * 2.如果有一天，需求变量，这个类的构造方法参数要添加n个参数，且构造方法重载，修改就比较麻烦，
         * 工厂同样是改代码，不过只需要改一处代码
         * 补充：有三种方法获得类的Class对象
         *    1. Class.forName("···")
         *    2. className.class
         *    3. 实例对象.getClass
         * 反射的用法  setAccessible Constructor newInstance
         * 简单工厂的缺点，一个方法只能有一种返回类型，如果需要生成新的类型，需要修改工厂
         **/

    }
}
