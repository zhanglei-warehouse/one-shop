package com.one.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_cart;
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
public interface Hg_cartMapper extends BaseMapper<Shop_cart> {

    List<Shop_cart> listByUid(Integer uid);

    List<Shop_cart> listByCids(int[] cartIds);

    @Select("select * from shop_cart where skuid=#{value}")
    Shop_cart selectBySkuId(int skuId);
    @Select("select * from shop_cart where uid=#{value}")
    Shop_cart selectByUid(int uid);
    @Select("SELECT sku.price,detail.num num,sku.price*detail.num total FROM shop_cartdetail detail  LEFT JOIN shop_sku sku on detail.skuid=sku.id LEFT JOIN shop_cart cart ON cart.id=detail.cid where cart.uid=#{value}")
    List<Shop_cart> selectAll(int uid);
    @Delete("delete from shop_cart where uid=#{value}")
    int deleteByUid(int uid);
}
