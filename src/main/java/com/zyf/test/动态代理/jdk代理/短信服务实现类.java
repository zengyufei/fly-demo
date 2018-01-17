package com.zyf.test.动态代理.jdk代理;

public class 短信服务实现类 implements 短信服务类 {
    @Override
    public boolean sendMsg(String content, String phoneNumber) {
        //模拟异常
        //int temp = 1 / 0;
        System.out.println(content + "," + phoneNumber);
        return true;
    }
}
