package com.atguigu.server;

import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface AddressServerInf {

	List<T_MALL_ADDRESS> get_addresses(T_MALL_USER_ACCOUNT user);

	T_MALL_ADDRESS get_address(int address_id);

}
