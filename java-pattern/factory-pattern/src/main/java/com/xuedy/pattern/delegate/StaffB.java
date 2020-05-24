package com.xuedy.pattern.delegate;

/**
 * @author Administrator
 * @className StaffB
 * @description TODO
 * @date {DATE}{TIME}
 */
public class StaffB implements Employee{
    @Override
    public void working(String command) {
        System.out.println("我是员工B ，我擅长后端"+command);
    }
}
