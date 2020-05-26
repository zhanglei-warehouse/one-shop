package com.one.shop.service.impl;

import com.one.shop.entity.Hg_cart;
import com.one.shop.entity.Shop_cart;
import com.one.shop.entity.Shop_sku;
import com.one.shop.mapper.Hg_cartMapper;
import com.one.shop.mapper.Hg_skuMapper;
import com.one.shop.service.IHg_cartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@Service
public class Hg_cartServiceImpl extends ServiceImpl<Hg_cartMapper, Shop_cart> implements IHg_cartService {

    @Autowired
    private Hg_cartMapper hg_cartMapper;
    @Autowired
    private Hg_skuMapper hg_skuMapper;
    @Override
    public List<Shop_cart> listByuId(Integer uid) {
        return hg_cartMapper.listByUid(uid);
    }

    @Override
    public int addCart(int uid, int skuId, int buyNum) {
        Shop_sku shop_sku = hg_skuMapper.selectById(skuId);
        Shop_cart shop_cart = new Shop_cart();
        shop_cart.setPnum(buyNum);
        shop_cart.setSkuid(skuId);
        shop_cart.setUid(uid);
        shop_cart.setSumtotal(shop_sku.getPrice()*buyNum);
        int insert = hg_cartMapper.insert(shop_cart);
        if(insert>0){
            return insert;
        }
        return 0;
    }
}
