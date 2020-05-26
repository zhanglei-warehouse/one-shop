package com.one.shop.mapper;

import com.one.shop.entity.Hg_sku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_sku;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface Hg_skuMapper extends BaseMapper<Shop_sku> {

    List<Shop_sku> listBySpu(int i);
}
