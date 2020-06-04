package com.renjack.webdemo.tools.shop;

import com.renjack.webdemo.tools.shop.goods.GoodsBase;
import com.renjack.webdemo.tools.shop.goods.all.Book;
import com.renjack.webdemo.tools.shop.goods.all.Box;
import org.assertj.core.util.Lists;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShopCar {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        GoodsBase box = new Box("商家A","box","拉箱",new BigDecimal("2.30"),localDate.toString(),3);
        GoodsBase book = new Book("商家B","book","水浒传",new BigDecimal("2.55"),localDate.toString(),localDate.minusDays(6).toString());

        List<GoodsBase> list = Lists.newArrayList();
        list.add(box);
        list.add(book);
        Collections.sort(list, new Comparator<GoodsBase>() {
            @Override
            public int compare(GoodsBase o1, GoodsBase o2) {
                return o1.compare(o2);
            }
        });

        System.out.println(box.compare(book));
    }

    public void main1() {

    }
}
