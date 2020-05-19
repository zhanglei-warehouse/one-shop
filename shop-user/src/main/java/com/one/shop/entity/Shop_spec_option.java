package com.one.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Shop_spec_option implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 规格项ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 规格项名称
     */
    private String option_name;

    /**
     * 规格ID
     */
    private Integer spec_id;

    /**
     * 排序值
     */
    private Integer orders;


}
