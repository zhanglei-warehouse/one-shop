package com.one.shop.service.impl;

import com.one.shop.entity.*;
import com.one.shop.mapper.*;
import com.one.shop.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Shop_orders> implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersdetailMapper ordersdetailMapper;
    @Autowired
    private Hg_skuMapper hg_skuMapper;
    @Autowired
    private Hg_cartMapper hg_cartMapper;

    @Override
    public int insert(Shop_orders orders) {
        System.out.println(orders+"-=-=--=");
        int insertorders = ordersMapper.insert(orders);
        if(insertorders>0){
            Integer[] skuIds = orders.getSkuIds();
            for (Integer skuid:skuIds
                 ) {
                Shop_sku shop_sku = hg_skuMapper.selectById(skuid);

                Shop_ordersdetail ordersdetail = new Shop_ordersdetail();
                ordersdetail.setOid(orders.getOid());
                ordersdetail.setPnum(1);
                ordersdetail.setSkuid(skuid);
                System.out.println(shop_sku.getPrice()*ordersdetail.getPnum()+"====");
                ordersdetail.setTotal(shop_sku.getPrice()*ordersdetail.getPnum());

                int insertDetail = ordersdetailMapper.insert(ordersdetail);
                if(insertDetail>0){
                    return insertDetail;
                }
            }
        }
        return 0;
    }
    //购物车的订单和订单详情
    @Override
    public int cartOrder(int uid, int[] cartIds, String address) {
        //定义一个数组
        int[] skuids = new int[cartIds.length];
        //根据购物车id值查询购物车列表
        List<Shop_cart> cartList= hg_cartMapper.listByUids(cartIds);
        //for循环购物车list
        for (int i=0;i<cartList.size();i++) {
            //获取购物车中的skuid商品属性id进行数组赋值
           skuids[i]=cartList.get(i).getSkuid();
            System.out.println(skuids[i]+"::skuids"+cartList.get(i).getSkuid());
        }
        //for循环购物车list
        for (Shop_cart cart:cartList
             ) {
            System.out.println(cart.getSumtotal() + "===="+cart);
            //new一个shop_order订单对象
            Shop_orders shop_orders = new Shop_orders();
            //uid用户id
            shop_orders.setUid(uid);
            //订单总价sql语句中c.pnum*k.price sumtotal
            shop_orders.setSumtotal(cart.getSumtotal());
            //地址
            shop_orders.setAddress(address);
            //订单添加
            int insertorders = ordersMapper.insert(shop_orders);
            //判断添加是否成功
            if (insertorders > 0) {
               // Integer[] skuIds = shop_orders.getSkuIds();
                //遍历skuid数组
                for (int i=0;i<skuids.length;i++
                ) {
                    System.out.println(skuids[i]+"::skuid");
                    //new 一个订单详情对象
                    Shop_ordersdetail ordersdetail = new Shop_ordersdetail();
                    //根据商品skuid查询
                   Shop_sku shop_sku = hg_skuMapper.selectById(skuids[i]);
                    System.out.println(shop_sku+"::shop_sku");
                   Shop_ordersdetail odetail= ordersdetailMapper.selectBySkuId(skuids[i]);
                   if(odetail!=null){
                       //商品数量
                       odetail.setPnum(odetail.getPnum()+1);
                       ordersdetailMapper.updateById(odetail);
                   }
                    else{
                    //设置订单id
                    ordersdetail.setOid(shop_orders.getOid());
                    //商品数量
                    ordersdetail.setPnum(1);
                    //用户商品属性id
                    ordersdetail.setSkuid(skuids[i]);
                    System.out.println(shop_sku.getPrice()+ "====");
                    System.out.println(ordersdetail.getPnum() + "====");
                    ordersdetail.setTotal(shop_sku.getPrice() * ordersdetail.getPnum());
                    int insertDetail = ordersdetailMapper.insert(ordersdetail);

                    }
                }
            }
        }
        for (int id:cartIds
             ) {
            hg_cartMapper.deleteById(id);
        }

        return 1;
    }
}
