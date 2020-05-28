package com.one.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_orders;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface OrdersMapper extends BaseMapper<Shop_orders> {

    List<Shop_orders> getByUid(int uid);
}
