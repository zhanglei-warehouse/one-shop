package com.one.shop.controller;


import com.one.shop.entity.Shop_city;
import com.one.shop.entity.Shop_cityVo;
import com.one.shop.service.IShop_cityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/shop_city")
public class Shop_cityController {

    @Autowired
    IShop_cityService iShop_cityService;

    @RequestMapping("listCity")
    public List<Shop_cityVo> listCity(){

        List<Shop_cityVo> list=iShop_cityService.listCity();

        return list;

    }


}

