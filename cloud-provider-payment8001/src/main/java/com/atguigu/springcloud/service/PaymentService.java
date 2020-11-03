package com.atguigu.springcloud.service;


import com.atguigu.springcloud.entities.Payment;


public interface PaymentService {


    //添加
    public int create(Payment payment);

    //查询
    public Payment getPaymentById(Long id);

}
