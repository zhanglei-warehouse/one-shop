package com.one.shop.mapper;

import com.one.shop.entity.Shop_cartdetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-29
 */
public interface Shop_cartdetailMapper extends BaseMapper<Shop_cartdetail> {
    List<Shop_cartdetail> findByCid(int cid);

    Shop_cartdetail selectBySkuId(int skuId);
    @Select("SELECT SUM(shop_cartdetail.num) num FROM shop_cartdetail")
    int selectNum();
    @Select("SELECT * FROM shop_cartdetail")
    List<Shop_cartdetail> selectAll();
}
