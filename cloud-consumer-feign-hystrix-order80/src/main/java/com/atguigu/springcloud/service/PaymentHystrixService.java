package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component        //添加声明controller的注解是为了后面调用时不会出现错误
//远程调用初心错误时使用兜底方法类
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE",fallback = PaymentFallbackService.class)  //远程调用的地址
public interface PaymentHystrixService {


    //调用成功的方法
    @GetMapping("/payment/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);


    //调用延时的方法
    @GetMapping("/payment/payment_Timeout/{id}")
    public String payment_Timeout(@PathVariable("id") Integer id);
}
