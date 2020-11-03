package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper   //mybatis提供的等价为   @MapperScan("com.atguigu.springcloud.dao")
public interface PaymentDao {

    //新增操作  create(创建)
    int create(Payment payment);
    //查询操作
    Payment getPaymentById(Long id);
}
