package com.one.shop.comment.controller;


import com.one.shop.comment.entity.Shop_comment2;
import com.one.shop.comment.service.IShop_comment2Service;
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
 * @since 2020-05-31
 */
@RestController
@RequestMapping("/shop_comment2")
public class Shop_comment2Controller {

    @Autowired
    private IShop_comment2Service iShop_comment2Service;

    /**
     * 添加用户评论信息
     * @param shop_comment2
     * @return
     */
    @RequestMapping("/comment2")
    public Object comment2(@RequestBody Shop_comment2 shop_comment2){
        try {
            iShop_comment2Service.save(shop_comment2);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

}

