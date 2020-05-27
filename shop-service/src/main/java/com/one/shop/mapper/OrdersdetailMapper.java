package com.one.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_ordersdetail;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface OrdersdetailMapper extends BaseMapper<Shop_ordersdetail> {
    @Select("select * from shop_ordersdetail where skuid=#{value}")
    Shop_ordersdetail selectBySkuId(Integer skuid);
}
