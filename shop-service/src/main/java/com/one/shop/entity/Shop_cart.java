package com.one.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author @one
 * @since 2020-05-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shop_cart implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private int uid;

    /**
     * 商品id(商品型号)
     */
    private int skuid;

    /**
     * 购买数量
     */
    private int pnum;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后修改时间
     */
    private Date updatetime;


    private Double sumtotal;
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private Double price;
    @TableField(exist = false)
    private String image;
    @TableField(exist = false)
    private int status;
    @TableField(exist = false)
    private String title;

}
