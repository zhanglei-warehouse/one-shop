package com.one.shop.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.shop.entity.Shop_spu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
public interface IShop_spuService extends IService<Shop_spu> {

    IPage<Shop_spu> selectPageVo(Page page, Shop_spu shop);

}
