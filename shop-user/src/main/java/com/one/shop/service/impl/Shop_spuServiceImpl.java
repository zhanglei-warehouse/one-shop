package com.one.shop.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.shop.entity.Shop_spu;
import com.one.shop.mapper.Shop_spuMapper;
import com.one.shop.service.IShop_spuService;
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
public class Shop_spuServiceImpl extends ServiceImpl<Shop_spuMapper, Shop_spu> implements IShop_spuService {
    @Autowired
    private Shop_spuMapper shop_spuMapper;


    @Override
    public IPage<Shop_spu> selectPageVo(Page page, Shop_spu shop) {
        return shop_spuMapper.selectPageVo(page,shop);
    }
}
