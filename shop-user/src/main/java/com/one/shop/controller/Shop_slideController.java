package com.one.shop.controller;


import com.one.shop.entity.Shop_slide;
import com.one.shop.service.IShop_slideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author @one
 * @since 2020-05-25
 */
@Controller
@RequestMapping("/slide")
public class Shop_slideController {
    @Autowired
    private IShop_slideService iShop_slideService;

    @RequestMapping("/slideList")
    public Object slideList(){
        List<Shop_slide> list = iShop_slideService.list();
        List<Object> slidelist=new ArrayList();
        for (Shop_slide s:list
             ) {
            System.out.println(s.getUrl());
            slidelist.add(s.getUrl());
        }



        return slidelist;
    }
}

