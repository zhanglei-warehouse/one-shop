package com.one.shop.mapper;

import com.one.shop.entity.Shop_address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
public interface Shop_addressMapper extends BaseMapper<Shop_address> {

    List<Shop_address> findAll(@Param("uid") Integer uid);

    boolean delAddress(Integer id);

    boolean addAddress(@Param("s") Shop_address shop_address);

    boolean updateAddress(@Param("s") Shop_address shop_address);
}
