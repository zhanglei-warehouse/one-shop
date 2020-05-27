package com.one.shop.service.impl;

import com.one.shop.entity.Shop_city;
import com.one.shop.entity.Shop_cityVo;
import com.one.shop.mapper.Shop_cityMapper;
import com.one.shop.service.IShop_cityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
@Service
public class Shop_cityServiceImpl extends ServiceImpl<Shop_cityMapper, Shop_city> implements IShop_cityService {

    @Autowired
    Shop_cityMapper shop_cityMapper;

    @Override
    public List<Shop_cityVo> listCity() {
        return shop_cityMapper.listCity();
    }
}
