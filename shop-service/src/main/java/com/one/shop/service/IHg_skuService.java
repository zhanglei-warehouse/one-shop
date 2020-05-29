package com.one.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.one.shop.entity.Shop_sku;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface IHg_skuService extends IService<Shop_sku> {

    List<Shop_sku> listBySpu(int i);
}
