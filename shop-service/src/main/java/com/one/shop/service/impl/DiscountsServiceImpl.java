package com.one.shop.service.impl;

import com.one.shop.entity.Discounts;
import com.one.shop.mapper.DiscountsMapper;
import com.one.shop.service.IDiscountsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanglei
 * @since 2020-05-29
 */
@Service
public class DiscountsServiceImpl extends ServiceImpl<DiscountsMapper, Discounts> implements IDiscountsService {

}
