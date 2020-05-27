package com.one.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.shop.entity.Shop_orders;
import com.one.shop.entity.Shop_sku;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface IOrdersService extends IService<Shop_orders> {

    int insert(Shop_orders orders);


    int cartOrder(int i, int[] cartIds, String address);

}
