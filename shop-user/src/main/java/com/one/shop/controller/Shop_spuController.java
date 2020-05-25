package com.one.shop.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.shop.entity.Shop_sku;
import com.one.shop.entity.Shop_spu;
import com.one.shop.service.IShop_skuService;
import com.one.shop.service.IShop_spuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/shop_spu")
public class Shop_spuController {

    @Autowired
    private IShop_spuService iShopSpuService;

    @RequestMapping("list")
    public Object list(@RequestParam(defaultValue = "1")Integer current, @RequestParam(defaultValue = "3")Integer pageSize,
                       Shop_spu shop){
        Page page=new Page(current,pageSize);
        IPage<Shop_spu> iPage=iShopSpuService.selectPageVo(page,shop);
        return iPage;

    }

}

