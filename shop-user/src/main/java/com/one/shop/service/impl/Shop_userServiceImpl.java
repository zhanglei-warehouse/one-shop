package com.one.shop.service.impl;

import com.one.shop.entity.Shop_user;
import com.one.shop.mapper.Shop_userMapper;
import com.one.shop.service.IShop_userService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@Service
public class Shop_userServiceImpl extends ServiceImpl<Shop_userMapper, Shop_user> implements IShop_userService {

    @Autowired
    Shop_userMapper shop_userMapper;


    @Override
    public boolean updateUser(Shop_user shop_user) {
        return shop_userMapper.updateUser(shop_user);
    }
}
