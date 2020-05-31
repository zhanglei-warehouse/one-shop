package com.one.shop.service.impl;

import com.one.shop.entity.Shop_address;
import com.one.shop.mapper.Shop_addressMapper;
import com.one.shop.service.IShop_addressService;
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
public class Shop_addressServiceImpl extends ServiceImpl<Shop_addressMapper, Shop_address> implements IShop_addressService {

    @Autowired
    Shop_addressMapper shop_addressMapper;


    @Override
    public List<Shop_address> findAll(Integer uid) {
        return shop_addressMapper.findAll(uid);
    }

    @Override
    public boolean delAddress(Integer id) {
        return shop_addressMapper.delAddress(id);
    }

    @Override
    public boolean addAddress(Shop_address shop_address) {
        return shop_addressMapper.addAddress(shop_address);
    }

    @Override
    public boolean updateAddress(Shop_address shop_address) {
        return shop_addressMapper.updateAddress(shop_address);
    }

    @Override
    public Shop_address findAllById(Integer id) {
        return shop_addressMapper.findAllById(id);
    }

    @Override
    public Shop_address findAllByStatus(int sta) {
        return shop_addressMapper.findAllByStatus(sta);
    }
}
