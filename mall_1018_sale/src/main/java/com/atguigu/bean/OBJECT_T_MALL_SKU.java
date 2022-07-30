package com.atguigu.bean;

/**
 * @author jian
 * @create 2022-07-19 17:07
 */
public class OBJECT_T_MALL_SKU extends T_MALL_SKU{

    private T_MALL_PRODUCT spu;
    private T_MALL_TRADE_MARK tm;

    public T_MALL_PRODUCT getSpu() {
        return spu;
    }

    public void setSpu(T_MALL_PRODUCT spu) {
        this.spu = spu;
    }

    public T_MALL_TRADE_MARK getTm() {
        return tm;
    }

    public void setTm(T_MALL_TRADE_MARK tm) {
        this.tm = tm;
    }
}
