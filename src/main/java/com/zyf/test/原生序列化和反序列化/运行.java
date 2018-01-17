package com.zyf.test.原生序列化和反序列化;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class 运行 {
    public static void main(String[] args) throws Exception {
        /*其中的  ./objectFile.obj 表示存放序列化对象的文件*/


        //序列化对象
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./objectFile.obj"));
        实体 customer = new 实体("王麻子", 24);
        out.writeObject("你好!");    //写入字面值常量
        out.writeObject(new Date());    //写入匿名Date对象
        out.writeObject(customer);    //写入customer对象
        out.close();


        //反序列化对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./objectFile.obj"));
        System.out.println("obj1 " + (String) in.readObject());    //读取字面值常量
        System.out.println("obj2 " + (Date) in.readObject());    //读取匿名Date对象
        实体 obj3 = (实体) in.readObject();    //读取customer对象
        System.out.println("obj3 " + obj3);
        in.close();
    }
}

