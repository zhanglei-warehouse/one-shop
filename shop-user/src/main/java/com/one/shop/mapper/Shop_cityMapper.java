package com.one.shop.mapper;

import com.one.shop.entity.Shop_city;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.one.shop.entity.Shop_cityVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
public interface Shop_cityMapper extends BaseMapper<Shop_city> {

    List<Shop_cityVo> listCity();
}
