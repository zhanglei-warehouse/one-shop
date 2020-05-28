package com.one.shop.controller;


import com.one.shop.entity.*;
import com.one.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Date;
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
@RequestMapping("/spu/")
public class  Hg_spuController {
    @Autowired
    private IHg_spuService iHg_spuService;
    @Autowired
    private IHg_skuService iHg_skuService;
    @Autowired
    private IHg_cartService iHg_cartService;
    @Autowired
    private IOrdersService iOrdersService;
    //商品
    @RequestMapping("spuDetail")
    public ResultEntity spuDetail(@RequestParam("id") Integer id){

        return ResultEntity.ok(iHg_spuService.getById(1));
    }
    //商品属性详情
    @RequestMapping("skuDetail")
    public ResultEntity skuDetail(@RequestParam("id") Integer id){
       // List<Hg_sku> list = iHg_skuService.listBySpu(1);
        List<Shop_sku> shop_skus = iHg_skuService.listBySpu(id);
        for (Shop_sku sku:shop_skus
             ) {
            System.out.println(sku);
        }
        return ResultEntity.ok(shop_skus);
    }

    //购物车提交订单
    @RequestMapping("cartOrder")
    public ResultEntity cartOrder(/*HttpServletRequest request, int[] cartIds, String address*/int[] cartIds){
        /*Shop_user user = (Shop_user) request.getSession().getAttribute();
        if(user==null) {
            request.setAttribute("error","您尚未登录");
            return ResultEntity.error("error");
        }*/
        return ResultEntity.ok(iOrdersService.cartOrder(1,cartIds,"河北"));
    }
}

