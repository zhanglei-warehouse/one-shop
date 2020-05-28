package com.one.shop.controller;


import com.one.shop.entity.ResultEntity;
import com.one.shop.entity.Shop_orders;
import com.one.shop.entity.Shop_user;
import com.one.shop.service.IOrdersService;
import com.one.shop.service.IOrdersdetailService;
import com.one.shop.service.IShop_ordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;
    @Autowired
    private IOrdersdetailService iOrdersdetailService;


    @RequestMapping("list")
    public ResultEntity list(HttpServletRequest request){
        /*Shop_user user = (Shop_user) request.getSession().getAttribute("");*/
        /*if(user==null) {
            return ResultEntity.error("亲，您尚未登录，不能加入购物车");
        }*/
        List<Shop_orders> list=iOrdersService.getByUid(1);


        return ResultEntity.ok(list);
    }
    @RequestMapping("del")
    public ResultEntity del(@RequestParam("oid") Integer detailId){
        boolean bl=iOrdersdetailService.removeById(detailId);
        if(bl){
            return ResultEntity.ok("成功");
        }
        return null;
    }

}

