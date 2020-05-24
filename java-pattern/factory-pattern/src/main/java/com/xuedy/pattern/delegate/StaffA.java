package com.xuedy.pattern.delegate;

/**
 * @author Administrator
 * @className StaffA
 * @description TODO
 * @date {DATE}{TIME}
 */
public class StaffA implements Employee{
    @Override
    public void working(String command) {
        System.out.println("我是员工A 我擅长前端"+command);
    }
}
