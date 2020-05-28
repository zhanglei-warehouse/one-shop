package com.one.shop.entity;

import lombok.Data;

import java.util.List;

@Data
public class Shop_cityVo {
    private Integer id;
    private String name;
    private List<Shop_cityVo> list;


}
