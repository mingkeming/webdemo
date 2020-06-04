package com.renjack.webdemo.tools.shop.goods;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class GoodsBase {

    /**
     * 商家
     */
    @NonNull
    private String shopName;

    /**
     * 品类
     */
    @NonNull
    private String goodsType;

    /**
     * 品名
     */
    @NonNull
    private String goodsName;

    /**
     * 价格
     */
    @NonNull
    private BigDecimal goodsPrice;

    /**
     * 购买时间
     */
    @NonNull
    private String buyTime;

    public Integer compare(GoodsBase otherGood){
        return this.goodsType.compareTo(otherGood.goodsType);
    }
}
