package com.one.shop.service.impl;

import com.one.shop.entity.Shop_cart;
import com.one.shop.entity.Shop_cartdetail;
import com.one.shop.entity.Shop_ordersdetail;
import com.one.shop.entity.Shop_sku;
import com.one.shop.mapper.Hg_cartMapper;
import com.one.shop.mapper.Hg_skuMapper;
import com.one.shop.mapper.Shop_cartdetailMapper;
import com.one.shop.service.IHg_cartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    @Autowired
    private Shop_cartdetailMapper shopCartdetailMapper;
    @Override
    public List<Shop_cart> listByuId(Integer uid) {
        return hg_cartMapper.listByUid(uid);
    }

    @Override
    public int addCart(int uid, int skuId, int buyNum) {
        Shop_cartdetail cartdetail= shopCartdetailMapper.selectBySkuId(skuId);
        int sumNum=0;
        Double sumtotal=0.0;

        Shop_cart cart= hg_cartMapper.selectByUid(uid);

        Shop_sku shop_sku = hg_skuMapper.selectById(skuId);

        Shop_cart shop_cart = new Shop_cart();
        shop_cart.setSkuid(skuId);
        shop_cart.setPnum(buyNum);
        shop_cart.setUid(uid);
        shop_cart.setSumtotal(shop_sku.getPrice()*buyNum);

        System.out.println(shop_sku.getPrice()+"getPrice");
        System.out.println(buyNum+"buynum");
        System.out.println(cart+":::cart");
        if(cart!=null){
            System.out.println(cartdetail+":::cartdetail");
            if(cartdetail!=null){
                cartdetail.setNum(buyNum);
                System.out.println(cartdetail.getNum()+"::::pnum=====");
                cartdetail.setTotal(shop_sku.getPrice()*cartdetail.getNum());
                System.out.println(cartdetail.getTotal()+"=========");
                int updateDetail=shopCartdetailMapper.updateById(cartdetail);
                if(updateDetail>0){
                    List<Shop_cart> shopCarts=  hg_cartMapper.selectAll(uid);
                    for (Shop_cart cartDetail:shopCarts
                    ) {
                        sumNum+=cartDetail.getNum();
                        System.out.println(sumNum+"：：在for里面的");
                        sumtotal+=cartDetail.getTotal();
                    }
                    System.out.println(sumNum+":::sumnum");
                    cart.setPnum(sumNum);
                    cart.setSumtotal(sumtotal);
                    int updateById = hg_cartMapper.updateById(cart);
                    return updateById;
                 }
                }else{
                Shop_cartdetail detail = new Shop_cartdetail();
                detail.setCid(cart.getId());
                detail.setSkuid(skuId);
                detail.setNum(buyNum);
                detail.setTotal(shop_sku.getPrice()*detail.getNum());
                detail.setCreatetime(new Date());
                int insertDetail = shopCartdetailMapper.insert(detail);
                if(insertDetail>0){
                    List<Shop_cart> shopCarts=  hg_cartMapper.selectAll(uid);
                    for (Shop_cart cartDetail:shopCarts
                    ) {
                        sumNum+=cartDetail.getNum();
                        System.out.println(sumNum+"：：在for里面的");
                        sumtotal+=cartDetail.getTotal();
                    }
                    System.out.println(sumNum+":::sumnum");
                    cart.setPnum(sumNum);
                    cart.setSumtotal(sumtotal);
                    int updateById = hg_cartMapper.updateById(cart);
                    return updateById;
                }
            }
        }else{
            int insert = hg_cartMapper.insert(shop_cart);
            if(insert>0){
                Shop_cartdetail detail = new Shop_cartdetail();
                detail.setCid(shop_cart.getId());
                detail.setSkuid(skuId);
                detail.setNum(buyNum);
                detail.setTotal(shop_sku.getPrice()*detail.getNum());
                detail.setCreatetime(new Date());
                int insertDetail = shopCartdetailMapper.insert(detail);
                if(insertDetail>0){
                    return insertDetail;
                }
            }
        }
        return 0;
    }
}
