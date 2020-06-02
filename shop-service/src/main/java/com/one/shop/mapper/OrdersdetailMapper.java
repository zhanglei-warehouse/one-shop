package com.one.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_ordersdetail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
    List<Shop_ordersdetail> selectBySkuId(Integer skuid);
    @Delete("delete from shop_ordersdetail where cid in (#{value})")
    int deleteByCid(int[] cartIds);
}
