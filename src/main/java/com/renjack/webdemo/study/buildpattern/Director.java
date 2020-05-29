package com.renjack.webdemo.study.buildpattern;

public class Director {
    private Builder builder;

    //1 构造方法的方式注入builder对象
    public Director(Builder builder) {
        this.builder = builder;
    }

    //2 set方法注入builder对象
    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}