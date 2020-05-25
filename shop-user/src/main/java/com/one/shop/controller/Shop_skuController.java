package com.one.shop.controller;

import com.one.shop.entity.Shop_sku;
import com.one.shop.service.IShop_skuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@RestController
@RequestMapping("/shop_sku")
public class Shop_skuController {

    @Autowired
    private IShop_skuService iShopSkuService;

    @RequestMapping("skuList")
    public Object skuList(){
        List<Shop_sku> list = iShopSkuService.list();
        return list;
    }

}

