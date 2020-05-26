package com.one.shop.service;

import com.one.shop.entity.Shop_user;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.shop.vo.ResultEntity;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
public interface IShop_userService extends IService<Shop_user> {


    ResultEntity login(Shop_user shop_user);

    ResultEntity register(Shop_user shop_user);

    boolean updateUser(Shop_user shop_user);
}
