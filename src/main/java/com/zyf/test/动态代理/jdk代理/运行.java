package com.zyf.test.动态代理.jdk代理;

public class 运行 {

    public static void main(String[] args) {
        短信服务类 iSmsSupport = new 短信服务实现类();
        短信服务类 proxy = (短信服务类) new 短信服务类代理(iSmsSupport).getProxy();
        proxy.sendMsg("aaa", "123");
    }

}
