package com.one.shop.mapper;

import com.one.shop.entity.Shop_user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
public interface Shop_userMapper extends BaseMapper<Shop_user> {

    boolean updateUser(@Param("s") Shop_user shop_user);
}
