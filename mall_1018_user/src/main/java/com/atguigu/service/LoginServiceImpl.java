package com.atguigu.service;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.LoginMapper;
import com.atguigu.utils.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jian
 * @create 2022-07-25 22:41
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user) {
        //切换数据源1
        MyRoutingDataSource.setKey("1");
        return loginMapper.select_user(user);
    }

    @Override
    public T_MALL_USER_ACCOUNT login2(T_MALL_USER_ACCOUNT user) {
        //切换数据源2
        MyRoutingDataSource.setKey("2");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return loginMapper.select_user(user);
    }
}
