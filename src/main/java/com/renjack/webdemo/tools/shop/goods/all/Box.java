package com.renjack.webdemo.tools.shop.goods.all;

import com.renjack.webdemo.tools.shop.goods.GoodsBase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Box extends GoodsBase {

    private Integer lengthSize;

    public Box(String shopName, String goodsType, String goodsName, BigDecimal goodsPrice, String buyTime, Integer lengthSize) {
        super(shopName, goodsType, goodsName, goodsPrice, buyTime);
        this.lengthSize = lengthSize;
    }

    @Override
    public Integer compare(GoodsBase otherGood) {
        Integer compareResult = super.compare(otherGood);
        return compareResult != 0 ? compareResult : this.lengthSize - ((Box)otherGood).lengthSize;
    }


}
