package com.one.shop.controller;


import com.one.shop.entity.Shop_user;
import com.one.shop.service.IShop_userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@RestController
@RequestMapping("/shop_user1")
public class Shop_userController {

    @Autowired
    IShop_userService iShop_userService;

    @RequestMapping("findById")
    public Shop_user findById(Integer id){
        Shop_user user = iShop_userService.getById(id);

        return user;

    }

    @RequestMapping("updateUser")
    public boolean updateUser(@RequestBody Shop_user shop_user){
        System.err.println(shop_user);
        boolean shopUser= iShop_userService.updateUser(shop_user);

        System.err.println(shopUser);

        return shopUser;
    }




}

