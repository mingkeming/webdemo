package com.renjack.webdemo.tools.shop.goods.all;

import com.renjack.webdemo.tools.shop.goods.GoodsBase;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class Book extends GoodsBase {

    private String printTime;

    public Book(String shopName, String goodsType, String goodsName, BigDecimal goodsPrice, String buyTime, String printTime) {
        super(shopName, goodsType, goodsName, goodsPrice, buyTime);
        this.printTime = printTime;
    }

    @Override
    public Integer compare(GoodsBase otherGood) {
        Integer compareResult = super.compare(otherGood);
        return compareResult != 0 ? compareResult : this.printTime.compareTo(((Book) otherGood).printTime);
    }
}
