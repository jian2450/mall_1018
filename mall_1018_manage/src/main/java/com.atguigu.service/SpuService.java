package com.atguigu.service;

import com.atguigu.bean.T_MALL_PRODUCT;

import java.util.List;

public interface SpuService {

	void save_spu(T_MALL_PRODUCT spu, List<String> list_image);

    List<T_MALL_PRODUCT> get_spu_list(int pp_id, int flbh2);
}
