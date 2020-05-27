package com.one.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.shop.entity.Shop_sku;
import com.one.shop.entity.Shop_spu;
import com.one.shop.mapper.Shop_skuMapper;
import com.one.shop.service.IShop_skuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@Service
public class Shop_skuServiceImpl extends ServiceImpl<Shop_skuMapper, Shop_sku> implements IShop_skuService {

    @Override
    public IPage<Shop_spu> selectPageVo(Page page, Shop_sku shop) {
        return null;
    }
}
