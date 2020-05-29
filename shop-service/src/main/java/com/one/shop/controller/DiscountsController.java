package com.one.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.one.shop.entity.Discounts;
import com.one.shop.service.IDiscountsService;
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
 * @author zhanglei
 * @since 2020-05-29
 */
@RestController
@RequestMapping("/discounts")
public class DiscountsController {

    @Autowired
    private IDiscountsService iDiscountsService;

    /**
     * 根据用户id和skuid查询优惠卷
     * @param uid
     * @param skuid
     * @return
     */
    @RequestMapping("list")
    public List<Discounts> list(int uid, int skuid){
        QueryWrapper<Discounts> discountsQueryWrapper = new QueryWrapper<>();
        discountsQueryWrapper.eq("uid",uid).eq("skuid",skuid).eq("status",0);
        List<Discounts> list = iDiscountsService.list(discountsQueryWrapper);
        return list;
    }

}

