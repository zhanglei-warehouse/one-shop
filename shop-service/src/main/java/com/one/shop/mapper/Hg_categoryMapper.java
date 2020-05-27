package com.one.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_category;

/**
 * <p>
 * 商品类目 Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface Hg_categoryMapper extends BaseMapper<Shop_category> {
    Shop_category findById(int id);
}
