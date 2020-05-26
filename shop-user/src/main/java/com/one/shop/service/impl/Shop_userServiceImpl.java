package com.one.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.one.shop.entity.Shop_user;
import com.one.shop.mapper.Shop_userMapper;
import com.one.shop.service.IShop_userService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.one.shop.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@Service
public class Shop_userServiceImpl extends ServiceImpl<Shop_userMapper, Shop_user> implements IShop_userService {

    @Resource
    private Shop_userMapper shop_userMapper;


    @Override
    public ResultEntity login(Shop_user shop_user) {
        //查询方法
        QueryWrapper<Shop_user> shop_userQueryWrapper = new QueryWrapper<>();
        shop_userQueryWrapper.eq("username",shop_user.getUsername());
        //查询单个
        Shop_user user = shop_userMapper.selectOne(shop_userQueryWrapper);
        //如果查到就判断密码是否相同
        if(user!=null){
            user.setPassword(DigestUtils.md5DigestAsHex(shop_user.getPassword().getBytes()));
            shop_userQueryWrapper.eq("password",user.getPassword());
            Shop_user u = shop_userMapper.selectOne(shop_userQueryWrapper);
            if(u!=null){
                //用户名字相同密码相同返回ok 为了安全问题 清空密码 密码不允许返回前台
                u.setPassword(null);
                return ResultEntity.ok(u);
            }else{
                //用户名正确 密码错误返回 密码错误
                return ResultEntity.error("密码错误");
            }
        }else{
            //用户不存在直接返回用户不存在
            return ResultEntity.error("该用户不存在");
        }
    }

    @Override
    public ResultEntity register(Shop_user shop_user) {
        String password = shop_user.getPassword();
        shop_user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        int insert = shop_userMapper.insert(shop_user);
        if(insert>0){
            return ResultEntity.ok("添加成功");
        }else{
            return ResultEntity.error("添加失败");
        }
    }

    @Override
    public boolean updateUser(Shop_user shop_user) {
        return shop_userMapper.updateUser(shop_user);
    }
}
