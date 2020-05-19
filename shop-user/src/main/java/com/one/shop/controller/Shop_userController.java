package com.one.shop.controller;


import com.one.shop.entity.Shop_user;
import com.one.shop.service.IShop_userService;
import com.one.shop.vo.ResultEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@RestController
@RequestMapping("/shop_user")
public class Shop_userController {

    @Resource
    private IShop_userService iShop_userService;

    /**
     *登录方法
     * 参数可以username，password
     * @return 1001登录成功返回user对象，1004登录失败具体信息在data中
     *
     */
    @RequestMapping("login")
    public ResultEntity login(Shop_user shop_user, HttpServletRequest httpServletRequest){

        ResultEntity res = iShop_userService.login(shop_user);
        //如果res中的data是user对象就存入session中
        if(res.getData() instanceof Shop_user){
            httpServletRequest.getSession().setAttribute("shop_user_session",res.getData());
        }
        return res;
    }
    /**
     *注册方法
     * 参数为shop_user对象
     * @return 1001注册成功返回成功信息，1004注册失败返回失败信息
     *
     */
    @RequestMapping("register")
    public ResultEntity register(Shop_user shop_user){
        ResultEntity res = iShop_userService.register(shop_user);
        return res;
    }
}

