package com.one.shop.service.impl;

import com.one.shop.entity.*;
import com.one.shop.mapper.*;
import com.one.shop.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Wrapper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Shop_orders> implements IOrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private OrdersdetailMapper ordersdetailMapper;
    @Autowired
    private Hg_skuMapper hg_skuMapper;
    @Autowired
    private Hg_cartMapper hg_cartMapper;
    @Autowired
    private Shop_cartdetailMapper shopCartdetailMapper;

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
        //总数量
        int[] totalNum=new int[cartIds.length];
        //根据购物车id值查询购物车列表
        List<Shop_cart> cartList= hg_cartMapper.listByCids(cartIds);
        //for循环购物车list
        for (int i=0;i<cartList.size();i++) {
            System.out.println(cartList.get(i)+"::::cartList");
            //获取购物车中的skuid商品属性id进行数组赋值
           skuids[i]=cartList.get(i).getSkuid();
            //总数量
           totalNum[i]=cartList.get(i).getNum();
            System.out.println(skuids[i]+"::skuids"+cartList.get(i).getSkuid());
        }
        //for循环购物车list
        for (int i=0;i<cartList.size();i++
             ) {
            System.out.println(cartList.get(i).getSumtotal() + "===="+cartList.get(i));
            //new一个shop_order订单对象
            Shop_orders shop_orders = new Shop_orders();
            //uid用户id
            shop_orders.setUid(uid);
            //订单总价sql语句中c.pnum*k.price sumtotal
            shop_orders.setSumtotal(cartList.get(i).getTotal());
            //地址
            shop_orders.setAddress(address);
            //订单添加
            int insertorders = ordersMapper.insert(shop_orders);
            //判断添加是否成功
            if (insertorders > 0) {
                // Integer[] skuIds = shop_orders.getSkuIds();
                System.out.println(skuids[i]+"::skuid");
                //new 一个订单详情对象
                Shop_ordersdetail ordersdetail = new Shop_ordersdetail();
                //根据商品skuid查询
               Shop_sku shop_sku = hg_skuMapper.selectById(skuids[i]);
                System.out.println(shop_sku+"::shop_sku");
                //设置订单id
                ordersdetail.setOid(shop_orders.getOid());
                //商品数量
                ordersdetail.setPnum(totalNum[i]);
                //用户商品属性id
                ordersdetail.setSkuid(skuids[i]);
                ordersdetail.setTotal(shop_sku.getPrice() * ordersdetail.getPnum());
                int insertDetail = ordersdetailMapper.insert(ordersdetail);
                }
            }
        for (int id:cartIds
             ) {
            Shop_cartdetail cartdetail = shopCartdetailMapper.selectById(id);
            int i = shopCartdetailMapper.deleteById(id);

            if(i>0){
                Shop_cart cart = hg_cartMapper.selectByUid(uid);
                cart.setSumtotal(cart.getSumtotal()-cartdetail.getTotal());
                cart.setPnum(cart.getPnum()-cartdetail.getNum());
                int updateById= hg_cartMapper.updateById(cart);
                if(updateById>0){
                    List<Shop_cartdetail> shop_cartdetails = shopCartdetailMapper.selectAll();
                    if(shop_cartdetails.size()==0){
                        hg_cartMapper.deleteByUid(uid);
                    }
                }
            }
           }
        return 1;
    }

    @Override
    public List<Shop_orders> getByUid(int uid) {
        List<Shop_orders> list=ordersMapper.getByUid(uid);
        System.out.println(list+"------");
        return list;
    }
}
