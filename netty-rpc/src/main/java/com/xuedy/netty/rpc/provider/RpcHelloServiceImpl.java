package com.xuedy.netty.rpc.provider;

import com.xuedy.netty.rpc.api.IRpcHelloService;

/**
 * @author Administrator
 * @className RpcHelloServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
public class RpcHelloServiceImpl implements IRpcHelloService {
    public void sayHello(String name) {
        System.out.println("hello"+name);

    }
}
