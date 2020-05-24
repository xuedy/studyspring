package com.xuedy.netty.rpc.provider;

import com.xuedy.netty.rpc.api.IRpcHelloService;
import com.xuedy.netty.rpc.api.IRpcService;

/**
 * @author Administrator
 * @className RpcServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
public class RpcServiceImpl implements IRpcService {
    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mult(int a, int b) {
        return a*b;
    }
}
