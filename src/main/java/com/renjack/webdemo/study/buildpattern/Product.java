package com.renjack.webdemo.study.buildpattern;

import lombok.Data;

@Data
public class Product {
    private String partA; //可以是任意类型

    private String partB;

    private String partC;

    @Override
    public String toString()
    {
        return "Product [partA=" + partA + ", partB=" + partB + ", partC=" + partC + "]";
    }
}