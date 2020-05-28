package com.one.shop.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author @one
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Shop_address implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer uid;

    private Integer shengid;

    private Integer shiid;

    private Integer xianid;

    private String name;

    private String phone;

    @TableField(exist = false)
    private String shengname;

    @TableField(exist = false)
    private String shiname;

    @TableField(exist = false)
    private String xianname;

    private String details;

}
