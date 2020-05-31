package com.one.shop.comment.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author @one
 * @since 2020-05-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shop_comment2 implements Serializable {

    private static final long serialVersionUID=1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 评分
     */
    private Integer grade;

    /**
     * 用户留言
     */
    private String userMessage;

    /**
     * 商品图片
     */
    private String shopImage;

    /**
     * 商品符合度
     */
    private Integer shopConformity;

    /**
     * 店铺服务态度
     */
    private Integer serviceAttitude;

    /**
     * 物流发货速度
     */
    private Integer logisticsDeliverySpeed;

    /**
     * 配送员服务
     */
    private Integer deliverymanService;


}
