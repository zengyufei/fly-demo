package com.zyf.test.jvm内存调试集合;

import java.util.Enumeration;
import java.util.Properties;

public class 一打印所有环境属性的变量和值 {

    public static void main(String[] args) {
        Properties sp = System.getProperties();
        Enumeration e = sp.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            System.out.println(key + "=" + sp.getProperty(key));
        }
    }
}
