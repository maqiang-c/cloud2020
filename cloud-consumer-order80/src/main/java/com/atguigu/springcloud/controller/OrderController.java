package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    //定义一个连接的常量   CLOUD-PAYMENT-SERVICE 为通过祖册中心获取的服务名称得到对应的服务实例(连接路径)
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;//远程调用需要负载均衡

    //添加的方法
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        //写操作  （url，requestMap，ResponseBean.class）
        // 这三个参数分别代表REST请求地址、请求参数、Http响应转换被转换成的对象类型。

        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    //查询操作一个
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById( @PathVariable("id") Long id){

        CommonResult template = restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return template;

    }

}
