package com.one.shop.entity;

import java.time.LocalDate;
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
public class Shop_comment implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer uid;

    private Integer sid;

    private String name;

    private LocalDate created;


}
