package com.xuedy.pattern.delegate;

/**
 * @author Administrator
 * @className Learder
 * @description TODO
 * @date {DATE}{TIME}
 */

public class Leader implements Employee{
    @Override
    public void working(String command) {

        System.out.println("我是Leader ，我擅长分配任务"+command);
        if("做前端".equals(command)){
            StaffA s=new StaffA();
            s.working("做前端");
        }else if("做后端".equals(command)){
            StaffB s=new  StaffB();
            s.working("做后端");
        }

    }
}
