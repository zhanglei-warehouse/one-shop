package com.one.shop.service;

import com.one.shop.entity.Hg_cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.shop.entity.Shop_cart;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface IHg_cartService extends IService<Shop_cart> {

    List<Shop_cart> listByuId(Integer uid);

    int addCart(int uid, int skuId, int buyNum);
}
