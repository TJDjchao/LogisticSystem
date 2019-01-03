package com.neo.controller;

import com.neo.entity.Order;
import com.neo.entity.ResponseMessage;
import com.neo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

@RestController
public class OrderController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    OrderMapper orderMapper;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    //新建订单
    @RequestMapping(path = "/order",method = RequestMethod.POST)
    public ResponseMessage addNewOrder(@RequestBody Order order){
        if(orderMapper.addNewOrder(order)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to add new order");
    }

    //完善订单
    //state 的值为0/1, 0 代表完善订单操作，1 代表更新订单操作
    @RequestMapping(path = "/order",method = RequestMethod.PUT)
    public ResponseMessage perfectOrder(@RequestBody Order order) {
        //完善订单，添加 FEE（费用） 和 WEIGHT（重量）
            if(orderMapper.perfectOrder(order)==1){
                return new ResponseMessage<>(null).success();
            }
            return new ResponseMessage<>(null).error(202,"fail to perfect order");
    }


    //更新订单
    @RequestMapping(path = "/orderstate",method = RequestMethod.GET)
    public ResponseMessage updateOrder(@RequestParam(value = "bill_id",required = false)Long bill_id,@RequestParam(value = "site_id",required = false)Long site_id,@RequestParam(value = "state",required = false)Long state){
        Date time1=new Date();
        if(orderMapper.updateOrder(bill_id,site_id,time1,state)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to update order");
    }

    //取消订单
    @RequestMapping(path = "/dorder",method = RequestMethod.DELETE)
    public ResponseMessage cancelOrder(@RequestParam(value = "BILL_ID",required = false)Long bill_id) {
            if(orderMapper.cancelOrder(bill_id)==1){
                return new ResponseMessage<>(null).success();
            }
            return new ResponseMessage<>(null).error(202,"fail to cancel order");
    }


    //查看订单
    @RequestMapping(path = "/order",method = RequestMethod.GET)
    public ResponseMessage getOrder(@RequestParam(value = "ACCOUNT_ID",required = false)Long account_id){
        List<Order> orders=orderMapper.getOrder(account_id);
        return new ResponseMessage<>(orders).success();
    }

    //搜索订单
    @RequestMapping(path = "/orders",method = RequestMethod.GET)
    public ResponseMessage searchOrder(@RequestParam(value = "BILL_ID",required = false)Long bill_id){
        List<Order> orders=orderMapper.searchOrder(bill_id);
        return new ResponseMessage<>(orders).success();
    }

}
