package com.one.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.shop.entity.Shop_sku;
import com.baomidou.mybatisplus.extension.service.IService;
import com.one.shop.entity.Shop_spu;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
public interface IShop_skuService extends IService<Shop_sku> {


    IPage<Shop_spu> selectPageVo(Page page, Shop_sku shop);

}
