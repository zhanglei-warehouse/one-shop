package com.one.shop.service;

import com.one.shop.entity.Shop_city;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.shop.entity.Shop_cityVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
public interface IShop_cityService extends IService<Shop_city> {

    List<Shop_cityVo> listCity();
}
