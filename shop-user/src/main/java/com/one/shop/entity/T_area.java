package com.one.shop.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@Data

@Table(name = "t_area")
public class T_area implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 名称
     */
    private String cityname;
    @Transient
    private List<T_area> areaList;

}
