package com.zyf.test.二维码生成;

import com.zyf.common.二维码生成工具类.QRCodeUtil;

public class 运行 {

    public static void main(String[] args) throws Exception {
        QRCodeUtil.encode("http://www.baidu.com/", "d:/");
    }
}
