package com.atguigu.springcloud.service;

public interface PaymentService {

    //调用成功的方法
    public String paymentInfo_OK(Integer id);
    //调用延时的方法
    public String payment_Timeout(Integer id);


    String paymentCircuitBreaker(Integer id);
}
