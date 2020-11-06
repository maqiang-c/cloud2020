package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient( value = "CLOUD-PAYMENT-SERVICE")//指远程调用的那个微服务
public interface PaymentFeignService {

    //需要与远程调用方法声明保持一致不然不会调用
    @GetMapping("/payment/get/{id}")  //GetMapping  查询的映射  PathVariable(路径变量)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id);



    //远程调用实验超时的接口
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
