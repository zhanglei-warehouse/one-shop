package com.one.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.one.shop.entity.T_area;
import com.one.shop.mapper.T_areaMapper;
import com.one.shop.service.IT_areaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhw
 * @since 2020-05-20
 */
@Service
public class T_areaServiceImpl  implements IT_areaService {

    @Autowired
    private T_areaMapper t_areaMapper;

    public List<T_area> getTree(){
        /*return  areaRepository.findByPid(1);*/
        //返回的结果
        List<T_area> proviceList = new ArrayList<>();
        //一次从数据查询所有数据
        List<T_area> all = t_areaMapper.findAll();
        //从all、查找省的数据
        all.forEach(provice->{
            if(provice.getPid()==0){
                proviceList.add(provice);
            }
        });
        //遍历省，查找市的数据
        proviceList.forEach(provice->{
            //查找省下面的所有市
            List<T_area> cityList = new ArrayList<>();
            all.forEach(ctiy->{
                if(ctiy.getPid().intValue()==provice.getId().intValue()){
                    cityList.add(ctiy);
                    //查找市下面的所有区
                    List<T_area> areaList = new ArrayList<>();
                    all.forEach(area->{
                        if(area.getPid().intValue()==ctiy.getId().intValue()){
                            areaList.add(area);
                        }
                    });
                    //设置区
                    ctiy.setAreaList(areaList);
                }
            });
            //设置城市
            provice.setAreaList(cityList);
        });
        return proviceList;
    }
}
