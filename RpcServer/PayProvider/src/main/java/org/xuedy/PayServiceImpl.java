package org.xuedy;

/**
 * @author Administrator
 * @className PayServiceImpl
 * @description TODO
 * @date {DATE}{TIME}
 */
public class PayServiceImpl implements PayService {
    @Override
    public String doPay(String msg) {
        System.out.println("执行doPay()"+msg);
        return "收到信息"+msg;
    }
}
