package com.atguigu.springcloud.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//@LoadBalanced
@SpringBootConfiguration
public class ApplicationContextConfig {

    @LoadBalanced  //RestTemplate集成ribbon组件进行负载均衡
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
