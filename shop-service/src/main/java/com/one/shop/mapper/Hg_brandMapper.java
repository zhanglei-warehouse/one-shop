package com.one.shop.mapper;

import com.one.shop.entity.Hg_brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface Hg_brandMapper extends BaseMapper<Hg_brand> {
    Hg_brand findById(int id);

}
