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
public class Shop_spu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * SPU名
     */
    private String goods_name;

    /**
     * 是否上架
     */
    private String is_marketable;

    /**
     * 品牌
     */
    private Integer brand_id;

    /**
     * 副标题
     */
    private String caption;

    /**
     * 一级类目
     */
    private Integer category_id;

    /**
     * 小图
     */
    private String small_pic;


}
