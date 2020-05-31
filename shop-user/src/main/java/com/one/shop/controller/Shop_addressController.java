package com.one.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.one.shop.entity.Shop_address;
import com.one.shop.service.IShop_addressService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/shop_address")
public class Shop_addressController {

    @Autowired
    IShop_addressService iShop_addressService;

    @RequestMapping("listAddress")
    public List<Shop_address> findAddress(Integer uid){
        QueryWrapper<Shop_address> wrapper = new QueryWrapper<>();

        wrapper.orderByDesc("status");
        wrapper.eq("uid", uid);
        List<Shop_address> list = iShop_addressService.list(wrapper);


        return list;
    }


    @RequestMapping("addAddress")
    public boolean addAddress(@RequestBody Shop_address shop_address){
        System.err.println(shop_address);
        shop_address.setStatus(0);
        return iShop_addressService.addAddress(shop_address);
    }

    @RequestMapping("updateAddress")
    public boolean updateAddress(@RequestBody Shop_address shop_address){
        System.err.println(shop_address);
        return iShop_addressService.updateAddress(shop_address);
    }

    @RequestMapping("delAddress")
    public boolean delAddress(Integer id){
        System.err.println(id);
        return iShop_addressService.delAddress(id);
    }

    @RequestMapping("moren")
    public boolean moren(Integer id){
        int sta=1;
        Shop_address address = iShop_addressService.findAllByStatus(sta);
        address.setStatus(0);
        iShop_addressService.updateById(address);

        Shop_address mo = iShop_addressService.findAllById(id);
        mo.setStatus(1);
        boolean save = iShop_addressService.updateById(mo);
        return save;
    }



}

