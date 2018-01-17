package com.zyf.test.原生序列化和反序列化;

import java.io.Serializable;

class 实体 implements Serializable {
    private String name;
    private int age;

    public 实体(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}
