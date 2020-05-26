package com.one.shop.service;

import com.one.shop.entity.T_area;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
public interface IT_areaService {

    List<T_area> getTree();
}
