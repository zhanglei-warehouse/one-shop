package com.one.shop.controller;


import com.one.shop.entity.ResultEntity;
import com.one.shop.service.IShop_cartdetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhw
 * @since 2020-05-29
 */
@Controller
@RequestMapping("/shop_cartdetail")
public class Shop_cartdetailController {
    @Autowired
    private IShop_cartdetailService iShop_cartdetailService;



}

