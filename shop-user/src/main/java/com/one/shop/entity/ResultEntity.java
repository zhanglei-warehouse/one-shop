package com.one.shop.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class ResultEntity implements Serializable {
    private static final long serialVersionUID=1L;

    //返回的状态码
    private Integer code;
    //返回状态码对应文本信息
    private String msg;
    //返回的数据
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultEntity() {
    }

    public ResultEntity(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultEntity ok(Object data){
        return new ResultEntity(1001,"ok",data);
    }

    public static ResultEntity error(Object data){
        return new ResultEntity(4001,"error",data);
    }
}
