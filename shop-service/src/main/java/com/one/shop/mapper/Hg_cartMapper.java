package com.one.shop.mapper;

import com.one.shop.entity.Hg_cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_cart;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface Hg_cartMapper extends BaseMapper<Shop_cart> {

    List<Shop_cart> listByUid(Integer uid);

    List<Shop_cart> listByUids(int[] cartIds);
}
