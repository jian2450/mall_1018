package com.atguigu.controller;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.service.CartService;
import com.atguigu.utils.MyJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-22 21:03
 */
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("change_shfxz")
    public String change_shfxz(@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie,
                               T_MALL_SHOPPINGCAR cart, HttpSession session, HttpServletResponse response, ModelMap map) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();
        //获取用户
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

//        //购物车修改业务
//        if (user == null){
//            //修改cookie
//            list_cart = MyJsonUtil.json_to_list(list_cart_cookie,T_MALL_SHOPPINGCAR.class);
//            for (int i = 0; i < list_cart.size(); i++) {
//                if (list_cart.get(i).getSku_id() == cart.getSku_id()){
//                    list_cart.get(i).setShfxz(cart.getShfxz());
//                }
//            }
//            //覆盖cookie
//            Cookie cookie = new Cookie("list_cart_cookie", MyJsonUtil.list_to_json(list_cart);
//            cookie.setMaxAge(60*60*24);
//            response.addCookie(cookie);
//
//        }else {
//            //修改db
//            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
//            for (int i = 0; i < list_cart.size(); i++) {
//                if (list_cart.get(i).getSku_id() == cart.getSku_id()){
//                    list_cart.get(i).setShfxz(cart.getShfxz());
//                    cartService.update_cart(list_cart.get(i));
//                }
//            }
//        }

        //购物车修改业务
        if (user == null) {
            //修改cookie
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
        } else {
            //修改db
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
        }

        for (int i = 0; i < list_cart.size(); i++) {
            if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                list_cart.get(i).setShfxz(cart.getShfxz());
                if (user == null) {
                    //覆盖cookie
                    Cookie cookie = new Cookie("list_cart_cookie", MyJsonUtil.list_to_json(list_cart));
                    cookie.setMaxAge(60 * 60 * 24);
                    response.addCookie(cookie);
                } else {
                    cartService.update_cart(list_cart.get(i));
                }
            }
        }

        map.put("sum", getSum(list_cart));
        map.put("list_cart", list_cart);
        return "cartListInner";
    }

    private BigDecimal getSum(List<T_MALL_SHOPPINGCAR> list_cart) {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < list_cart.size(); i++) {
            if (("1").equals(list_cart.get(i).getShfxz())) {
                sum = sum.add(new BigDecimal(list_cart.get(i).getHj() + ""));
            }
        }
        return sum;
    }

    @RequestMapping("goto_cart_list")
    public String goto_cart_list(@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie,
                                 HttpSession session, ModelMap map) {
        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();
        //获取用户
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

        if (user == null) {
            //未登录，cookie中获取
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
        } else {
            //登录，session中获取购物车数据
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
        }

        map.put("sum", getSum(list_cart));
        map.put("list_cart", list_cart);
        return "cartList";
    }

    @RequestMapping("miniCart")
    public String miniCart(@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie,
                           HttpSession session, ModelMap map) {

        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<>();
        //获取用户
        T_MALL_USER_ACCOUNT user = (T_MALL_USER_ACCOUNT) session.getAttribute("user");

        if (user == null) {
            //未登录，cookie中获取
            list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
        } else {
            //登录，session中获取购物车数据
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
        }

        map.put("list_cart", list_cart);
        return "miniCartList";
    }

    @RequestMapping("add_cart")
    public String add_cart(@CookieValue(value = "list_cart_cookie", required = false) String list_cart_cookie,
                           HttpSession session, HttpServletResponse response, T_MALL_SHOPPINGCAR cart, ModelMap map) {

        List<T_MALL_SHOPPINGCAR> list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
        int yh_id = cart.getYh_id();

        //添加购物车
        if (yh_id == 0) {
            //用户未登录，操作cookie
            if (StringUtils.isBlank(list_cart_cookie)) {
                list_cart.add(cart);
            } else {
                list_cart = MyJsonUtil.json_to_list(list_cart_cookie, T_MALL_SHOPPINGCAR.class);
                boolean b = if_new_cart(list_cart, cart);
                //判断是否重复
                if (b) {
                    //新车，添加
                    list_cart.add(cart);
                } else {
                    //老车，更新
                    for (int i = 0; i < list_cart.size(); i++) {
                        if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                            list_cart.get(i).setTjshl(list_cart.get(i).getTjshl() + cart.getTjshl());
                            list_cart.get(i).setHj(list_cart.get(i).getTjshl() * list_cart.get(i).getSku_jg());
                        }
                    }
                }
            }
            //覆盖cookie
            Cookie cookie = new Cookie("list_cart_cookie", MyJsonUtil.list_to_json(list_cart));
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
        } else {
            list_cart = (List<T_MALL_SHOPPINGCAR>) session.getAttribute("list_cart_session");
            //已登录,操作db
            boolean b = cartService.if_cart_exists(cart);

            if (!b) {
                //不重复
                cartService.add_cart(cart);
                if (list_cart == null || list_cart.isEmpty()) {
                    list_cart = new ArrayList<T_MALL_SHOPPINGCAR>();
                    list_cart.add(cart);
                    session.setAttribute("list_cart_session", list_cart);
                } else {
                    list_cart.add(cart);
                }
            } else {
                for (int i = 0; i < list_cart.size(); i++) {
                    if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                        list_cart.get(i).setTjshl(list_cart.get(i).getTjshl() + cart.getTjshl());
                        list_cart.get(i).setHj(list_cart.get(i).getTjshl() * list_cart.get(i).getSku_jg());
                        // 老车，更新
                        cartService.update_cart(list_cart.get(i));
                    }
                }
            }
        }

        return "redirect:/cart_success.do";
    }

    private boolean if_new_cart(List<T_MALL_SHOPPINGCAR> list_cart, T_MALL_SHOPPINGCAR cart) {
        boolean b = true;
        for (int i = 0; i < list_cart.size(); i++) {
            if (list_cart.get(i).getSku_id() == cart.getSku_id()) {
                b = false;
            }
        }
        return b;
    }

    @RequestMapping("cart_success")
    public String cart_success(ModelMap map) {

        return "cartSuccess";
    }
}
