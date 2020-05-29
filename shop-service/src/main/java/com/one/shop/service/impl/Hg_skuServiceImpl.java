package com.one.shop.service.impl;

import com.one.shop.entity.Shop_sku;
import com.one.shop.mapper.Hg_skuMapper;
import com.one.shop.service.IHg_skuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@Service
public class Hg_skuServiceImpl extends ServiceImpl<Hg_skuMapper, Shop_sku> implements IHg_skuService {

    @Autowired
    private Hg_skuMapper hg_skuMapper;

    @Override
    public List<Shop_sku> listBySpu(int i) {
        return hg_skuMapper.listBySpu(i);
    }
}
