package com.atguigu.controller;

import com.atguigu.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.server.LoginServer;
import com.atguigu.server.TestServer;
import com.atguigu.service.CartService;
import com.atguigu.utils.MyJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-16 23:09
 */
@Controller
public class LoginController {

    @Autowired
    CartService cartService;

    @Autowired
    LoginServer loginServer;

    @Autowired
    TestServer testServer;

    /**
     * 表单异步提交
     */
    @RequestMapping(value = "login1", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String index(MODEL_T_MALL_SKU_ATTR_VALUE list_attr, T_MALL_USER_ACCOUNT user) {

        return "成功";
    }

    @RequestMapping("login")
    public String goto_login(@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie,
                             HttpServletResponse response, HttpSession session, T_MALL_USER_ACCOUNT user,
                             @RequestParam(value = "redirect",required = false)String redirect, String dataSource_type, ModelMap map) {

        T_MALL_USER_ACCOUNT select_user = new T_MALL_USER_ACCOUNT(); //loginMapper.select_user(user);
        String loginJson = "";

        //登陆，远程用户认证接口
        if (("1").equals(dataSource_type)) {
            loginJson = loginServer.login(user);
            testServer.ping("hello");
        } else if (("2").equals(dataSource_type)) {
            loginJson = loginServer.login2(user);
        }

        select_user = MyJsonUtil.json_to_object(loginJson, T_MALL_USER_ACCOUNT.class);

        if (select_user == null) {
            return "redirect:/login.do";
        } else {
            session.setAttribute("user", select_user);

            //客户端存储客户的个性化信息，方便用户下次再访问网站时使用
            Cookie cookie = null;
            Cookie cookie1 = null;
            try {
                cookie = new Cookie("yh_mch", URLEncoder.encode(select_user.getYh_mch(), "utf-8"));
                // cookie.setPath("/");
                cookie.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie);

                cookie1 = new Cookie("yh_nch", URLEncoder.encode("汤姆", "utf-8"));
                // cookie.setPath("/");
                cookie1.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie1);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            //同步购物车数据
            combine(select_user, response, session, list_cart_cookie);

        }

        if (StringUtils.isBlank(redirect)){
            return "redirect:/index.do";
        }else {
            return "redirect:/"+redirect;
        }

    }

    private void combine(T_MALL_USER_ACCOUNT user, HttpServletResponse response,
                         HttpSession session, String list_cart_cookie) {

        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();

        //判断cookie是否为空
        if (StringUtils.isBlank(list_cart_cookie)) {
            //
        } else {
            //判断db是否为空
            List<T_MALL_SHOPPINGCAR> list_cart_db = cartService.get_list_cart_by_user(user);
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);

            for (int i = 0; i < list_cart.size(); i++) {
                T_MALL_SHOPPINGCAR cart = list_cart.get(i);
                cart.setYh_id(user.getId());
                boolean b = cartService.if_cart_exists(cart);

                if (b) {
                    //重复，更新
                    for (int j = 0; j < list_cart_db.size(); j++) {
                        if (cart.getSku_id() == list_cart_db.get(j).getSku_id()) {
                            cart.setTjshl(cart.getTjshl() + list_cart_db.get(j).getTjshl());
                            cart.setHj(cart.getTjshl() * cart.getSku_jg());
                            cartService.update_cart(cart);
                        }
                    }
                } else {
                    //添加
                    cartService.add_cart(cart);
                }
            }
        }

        //同步session,清除cookie
        session.setAttribute("list_cart_session", cartService.get_list_cart_by_user(user));
        response.addCookie(new Cookie("list_cart_cookie", ""));


//            if (list_cart_db == null || list_cart_db.size()==0 ){
//                for (int i = 0; i < list_cart.size(); i++) {
//                    //客户端的cookie是没有用户id的，需要进行设置
//                    list_cart.get(i).setYh_id(user.getId());
//                    cartService.add_cart(list_cart.get(i));
//                }
//            }else {
//                //判断是否重复
//                for (int i = 0; i < list_cart.size(); i++) {
//
//                    boolean b = if_new_cart(list_cart_db,list_cart.get(i));
//
//                    if (b){
//                        //不重复，添加
//                        list_cart.get(i).setYh_id(user.getId());
//                        cartService.add_cart(list_cart.get(i));
//                    }else {
//                        //更新
//                        for (int j = 0; j < list_cart_db.size(); j++) {
//                            if (list_cart.get(i).getSku_id()==list_cart_db.get(i).getSku_id() ){
//                                list_cart.get(i).setTjshl(list_cart.get(i).getTjshl()+list_cart_db.get(j).getTjshl());
//                                list_cart.get(i).setHj(list_cart.get(i).getTjshl()*list_cart.get(i).getSku_jg());
//                                cartService.update_cart(list_cart.get(i));
//                            }
//                        }
//                    }
//                }
//            }
    }

    private boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart_db, T_MALL_SHOPPINGCAR cart) {
        boolean b = true;
        for (int i = 0; i < list_cart_db.size(); i++) {
            if (list_cart_db.get(i).getSku_id() == cart.getSku_id()) {
                b = false;
            }
        }
        return b;
    }


}
