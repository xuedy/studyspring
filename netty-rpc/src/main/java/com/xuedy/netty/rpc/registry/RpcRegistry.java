package com.xuedy.netty.rpc.registry;

/**
 * @author Administrator
 * @className Registry
 * @description TODO
 * @date {DATE}{TIME}
 */
public class RpcRegistry {
    private int port;
    public RpcRegistry(int port){
        this.port=port;
    }
    public void start()
    {
        //Selector 主线程，work 线程
        EventLoopGroup  mainGroup=new EventLoopGroup();
        EventLoopGroup  workerGroup=new EventLoopGroup();
        ServerBootstrap server=new ServerBootstrap();
        server.group(mainGroup,workerGroup);
    }
    public static void main(String[] args) {
        new RpcRegistry(8080);

    }

}
