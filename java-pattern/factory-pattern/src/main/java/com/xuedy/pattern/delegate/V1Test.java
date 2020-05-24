package com.xuedy.pattern.delegate;

/**
 * @author Administrator
 * @className V1Test
 * @description TODO
 * @date {DATE}{TIME}
 */
public class V1Test {
    public static void main(String[] args) {
        Boss boss=new Boss(new Leader());
        boss.command("做前端");
    }
}
