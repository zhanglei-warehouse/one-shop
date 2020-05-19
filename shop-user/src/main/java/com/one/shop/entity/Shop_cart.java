package com.one.shop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
    private String uid;

    /**
     * 商品id(商品型号)
     */
    private String skuid;

    /**
     * 购买数量
     */
    private BigDecimal pnum;

    /**
     * 创建时间
     */
    private LocalDateTime createtime;

    /**
     * 最后修改时间
     */
    private LocalDateTime updatetime;

    private BigDecimal sum_total;


}
