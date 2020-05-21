package com.renjack.webdemo.tools;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        String a = localDate.toString();
        BigDecimal bg = new BigDecimal("1.23564788");
        String a1 = String.format("%s",bg);

        if (null == null ){
            System.out.println(1);
        }
        ParamA paramA = new ParamA();
        paramA.setTypeM("a1");
        paramA.setTypeN("a2");
        paramA.setTypeF("a3");
        ParamB paramB = new ParamB();
        BeanCopier beanCopier = BeanCopier.create(paramA.getClass(), paramB.getClass(), false);
        long begin = System.currentTimeMillis();
        for(int i = 0; i< 10000010;i++){
            BeanUtils.copyProperties(paramA, paramB);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        long begin1 = System.currentTimeMillis();
        for(int i = 0; i< 10000010;i++){

            beanCopier.copy(paramA, paramB, null);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - begin1);

    }

    public  static String getNewFileName(String fileName){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYYMMdd");
        String date = localDateTime.format(dateTimeFormatter);
        Integer index = fileName.lastIndexOf(".");
        String fileNameNew ;
        if(index > 0){
            fileNameNew = fileName.substring(0,index) + System.currentTimeMillis() + "." + fileName.substring(index);
        }else{
            fileNameNew = fileName + System.currentTimeMillis();
        }
        return fileNameNew;
    }

}


@Data
class ParamA{
    String typeM;
    String typeN;
    String typeF;
}

@Data
class ParamB{
    String typeM;
    String typeN;
    String typeF;
}