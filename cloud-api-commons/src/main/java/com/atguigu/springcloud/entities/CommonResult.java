package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {

    private Integer code; //返回的码
    private String message;  //返回的信息
    private T data;   //返回的参数

    public CommonResult(Integer code, String message ) {
        this(code,message,null);

    }
}
