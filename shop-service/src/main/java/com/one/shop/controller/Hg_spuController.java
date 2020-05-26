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
public class Hg_spuController {
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
    @RequestMapping("addOrder")
    public ResultEntity addOrder(@RequestBody Shop_orders shop_orders){
      /*  Integer[] skuIds=new Integer[1];
        skuIds[0]=1;
        Shop_orders shop_orders = new Shop_orders();
        shop_orders.setAddress("河北");
        shop_orders.setSkuIds(skuIds);
        shop_orders.setSumtotal(1.0);
        shop_orders.setUid(1);
        shop_orders.setSkuIds(skuIds);*/
        return ResultEntity.ok(iOrdersService.insert(shop_orders));
    }
    //购物车提交订单
    @RequestMapping("cartOrder")
    public ResultEntity cartOrder(/*HttpServletRequest request, int[] cartIds, String address*,int[] skuids*/int[] cartIds){
        /*Shop_user user = (Shop_user) request.getSession().getAttribute();
        if(user==null) {
            request.setAttribute("error","您尚未登录");
            return ResultEntity.error("error");
        }*/

        //int insertOrder = iOrdersService.cartOrder(uid,cartIds,address);
        int[] cartId=new int[1];
        cartId[0]=1;
        int[] skuid=new int[1];
        skuid[0]=1;
        return ResultEntity.ok(iOrdersService.cartOrder(1,cartIds,"河北"));
    }
}

