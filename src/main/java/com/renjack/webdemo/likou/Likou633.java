package com.renjack.webdemo.likou;

/**
 * @program: 计算一个整数是否为两个整数的平方和
 * @description:
 * @author: Jack
 * @create: 2020-02-22 10:04
 **/
class Likou633 {

    public static void main(String[] args) {
        System.out.println(new Likou633().judgeSquareSum(78379897));
    }

    public boolean judgeSquareSum(int c) {
        int biggest = (int)Math.sqrt(c);
        int small = 0;
        int big = biggest;
        for(;;){
            if(small > big ){
                return false;
            }
            int sum = small * small + big * big;
            if(sum == c){
                return true;
            }else if(sum < c){
                small = small + 1;
            }else if(sum > c){
                big = big  - 1;
            }
        }
    }
}