package com.one.shop.controller;


import com.one.shop.entity.ResultEntity;
import com.one.shop.entity.Shop_user;
import com.one.shop.service.IHg_cartService;
import com.one.shop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/cart/")
public class Hg_cartController {
    @Autowired
    private IHg_cartService iHg_cartService;
    @Autowired
    private IOrdersService iOrdersService;
    //加入购物车
    @RequestMapping("add")
    private ResultEntity addCart(/*HttpServletRequest request, */@RequestParam("skuid") int skuid,@RequestParam("buynum") int buynum){
        //Shop_user user = (Shop_user) request.getSession().getAttribute();
        /*if(user==null) {
            return ResultEntity.error("亲，您尚未登录，不能加入购物车");
        }*/
        System.out.println(buynum+"数量");
        //int addCart = iHg_cartService.addCart(uid, skuId, buyNum);

        int addCart = iHg_cartService.addCart(1, skuid, buynum);
        if(addCart>0){
            return ResultEntity.ok("成功");
        }
        return ResultEntity.error("失败");
    }
    //根据用户id查询购物车列表
    @RequestMapping("cartList")
    public ResultEntity cartList(@RequestParam("uid") Integer uid){
        return ResultEntity.ok(iHg_cartService.listByuId(uid));
    }
    @RequestMapping("del")
    public ResultEntity del(@RequestParam("id") Integer id){
        return ResultEntity.ok(iHg_cartService.removeById(id));
    }

    @RequestMapping("selectOrder")
    public ResultEntity selectOrder(Integer uid){
        boolean b = iOrdersService.selectOrder(uid);
        if(b){
            return ResultEntity.ok("该用户没有订单,可以享受首单九五折");
        }else{
            return ResultEntity.error("该用户有订单");
        }
    }
}

