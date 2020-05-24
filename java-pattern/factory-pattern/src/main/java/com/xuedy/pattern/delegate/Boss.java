package com.xuedy.pattern.delegate;

/**
 * @author Administrator
 * @className Boss
 * @description TODO
 * @date {DATE}{TIME}
 */
public class Boss {
    private Leader leader;

    public Boss(Leader leader) {
        this.leader = leader;
    }


    public void command(String command){
        System.out.println("我是老板，下达命令");
        leader.working(command);
    }
}
