package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

@Configuration   //表示这是一个配置类
public class FeignConfig {


    //配置打印日志
    private Logger.Level feignLoggerLevel (){
        return Logger.Level.FULL;
    }
}
