package com.atguigu.server;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.service.LoginService;
import com.atguigu.utils.MyRoutingDataSource;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;

/**
 * @author jian
 * @create 2022-07-25 22:33
 */
public class LoginServerImpl implements LoginServer{

    @Autowired
    private LoginService loginService;

    @Override
    @Path("login")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String login(@BeanParam T_MALL_USER_ACCOUNT user) {

        //在事务管理器之前切换数据源
        MyRoutingDataSource.setKey("2");

        T_MALL_USER_ACCOUNT select_user = loginService.login(user);

        Gson gson = new Gson();
        return gson.toJson(select_user);
    }

    @Override
    @Path("login")
    @GET
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public String login2(@BeanParam T_MALL_USER_ACCOUNT user) {

        T_MALL_USER_ACCOUNT select_user = loginService.login2(user);

        Gson gson = new Gson();
        return gson.toJson(select_user);
    }
}
