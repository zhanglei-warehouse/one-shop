package com.one.shop.controller;


import com.one.shop.entity.ResultEntity;
import com.one.shop.service.IT_areaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/area/")
public class T_areaController {

    @Autowired
    private IT_areaService it_areaService;

    @RequestMapping("list")
    public ResultEntity list(){

        return ResultEntity.ok(it_areaService.getTree());
    }
}

