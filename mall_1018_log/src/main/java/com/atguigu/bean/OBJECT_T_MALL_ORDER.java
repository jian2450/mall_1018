package com.atguigu.bean;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-27 21:49
 */
public class OBJECT_T_MALL_ORDER extends T_MALL_ORDER {

    public List<OBJECT_T_MALL_FLOW> getList_flow() {
        return list_flow;
    }

    public void setList_flow(List<OBJECT_T_MALL_FLOW> list_flow) {
        this.list_flow = list_flow;
    }

    private List<OBJECT_T_MALL_FLOW> list_flow;


}
