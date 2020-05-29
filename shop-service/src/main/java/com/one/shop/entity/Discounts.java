package com.one.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhanglei
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("shop_discounts")
public class Discounts implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    /**
     * 用户外键
     */
    private Integer uid;

    private String name;

    private Integer price;

    /**
     * 商品外键
     */
    private Integer skuid;

    /**
     * 使用状态 1使用 0未使用
     */
    private Integer status;


}
