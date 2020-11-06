package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.valueextraction.ExtractedValue;

@Slf4j  //打印日志
@RestController    //将这个controller返回值转化json对象传输
public class PaymentController {

    @Autowired  //调用service层
    PaymentService paymentService;

    @Value("${server.port}")  //获取端口号
    private String serverPort;

    //调用成功的方法
    @GetMapping("/payment/paymentInfo_OK/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*******result:"+result+serverPort);
        return result;
    };
    //调用延时的方法
    @GetMapping("/payment/payment_Timeout/{id}")
    public String payment_Timeout(@PathVariable("id") Integer id){
        String result = paymentService.payment_Timeout(id);
        log.info("*******result:"+result+serverPort);
        return result;
    };



    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }

}
