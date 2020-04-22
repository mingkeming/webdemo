package com.renjack.webdemo.tools;

public class LargeNumMultiply {

    public static void main(String[] argv) {
        String num1 = "1000000000000";//第一个大数字
        String num2 = "123456789";//第二个大数字
        String[] numStrs = num1.split("");
        Integer[] nums1 = new Integer[numStrs.length];
        for(int i = 0; i < numStrs.length; i++){
            nums1[i] = Integer.parseInt(numStrs[i]);
        }
        numStrs = num2.split("");
        Integer[] nums2 = new Integer[numStrs.length];
        for(int i = 0; i < numStrs.length; i++){
            nums2[i] = Integer.parseInt(numStrs[i]);
        }
        int[] result = new int[num1.length() + num2.length()];
        int size = result.length;
        int num1Size = nums1.length;
        int num2Size = nums2.length;
        //i和j都为从右到左的位置
        for(int i = 0; i < num2.length(); i++){
            for(int j = 0; j < num1.length(); j++){
                result[size - i - j -1 ] += nums2[num2Size - i -1 ] * nums1[num1Size - j -1];
            }
        }
        for(int i = size - 1; i > 0; i--){
            result[i - 1] += result[i] / 10;
            result[i] = result[i] % 10;
        }
        boolean isBegin = false;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < size;i++){
            if(!isBegin && result[i] != 0){
                isBegin = true;
            }
            if(isBegin){
                stringBuilder.append(result[i]);
            }
        }
        System.out.println(stringBuilder);
    }
}

