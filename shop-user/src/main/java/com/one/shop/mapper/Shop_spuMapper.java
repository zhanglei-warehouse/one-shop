package com.one.shop.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.one.shop.entity.Shop_spu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
public interface Shop_spuMapper extends BaseMapper<Shop_spu> {

    IPage<Shop_spu> selectPageVo(Page page, Shop_spu shop);

}
