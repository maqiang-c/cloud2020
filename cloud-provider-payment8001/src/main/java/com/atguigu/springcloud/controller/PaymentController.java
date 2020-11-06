package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController  //服务提供者不跳转页面的,一般直接将数据已JSON返回
@Slf4j  //内置log对象   它用来记录日志
public class PaymentController {

    @Value("${server.port}")
    Integer port;
    @Autowired
    PaymentService paymentService;
    
    //添加
    @PostMapping ("/payment/create") //添加操作的映射
    //@requestbody   获取请求体数据可能是json  将json封装为bean对象
    public CommonResult<Payment> create(@RequestBody Payment payment){  //CommonResult为我们定义的一个JSON队像

        try {   //添加异常情况
            int count = paymentService.create(payment);
            if (count == 1) {  //添加成功
                log.debug("添加成功"+payment);
                return new CommonResult<>(20000,"添加成功",payment);
            } else {  //添加失败
                log.debug("添加失败"+payment);
                return new CommonResult<>(40000,"添加失败",payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("添加异常"+e.getMessage());
            return new CommonResult<>(9999,"添加异常="+e.getMessage());
        }
    }

    @GetMapping("/payment/get/{id}")  //GetMapping  查询的映射  PathVariable(路径变量)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){

        try {
            Payment payment1 = paymentService.getPaymentById(id);
            if (payment1 == null) {//查询失败
                log.debug("未查询到信息"+payment1);  //打印日志信息
                return new CommonResult<Payment>(40000,"未查询到信息");
            } else {//查询成功
                log.debug("查询成功"+payment1);
                return  new CommonResult<>(20000,"查询成功"+port,payment1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询异常"+e.getMessage());
            return  new CommonResult<>(99999,"查询时异常="+e.getMessage());
        }
    };



    //实验超时问题
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);  //睡三秒
        } catch (Exception e) {
            e.printStackTrace();
        } //单位秒
        return port+"";


    }
}
