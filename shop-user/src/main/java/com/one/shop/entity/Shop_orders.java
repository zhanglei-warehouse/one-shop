package com.one.shop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Shop_orders implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    private Integer uid;

    private Double sumtotal;

    private String address;

    private LocalDate create_time;

    @TableField(exist = false)
    private Integer[] skuIds;

}
