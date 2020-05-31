package com.one.shop.service;

import com.one.shop.entity.Shop_address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
public interface IShop_addressService extends IService<Shop_address> {

    List<Shop_address> findAll(Integer uid);

    boolean delAddress(Integer id);

    boolean addAddress(Shop_address shop_address);

    boolean updateAddress(Shop_address shop_address);


    Shop_address findAllById(Integer id);

    Shop_address findAllByStatus(int sta);
}
