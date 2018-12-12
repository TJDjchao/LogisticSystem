package com.neo.controller;

import com.neo.entity.Order;
import com.neo.entity.ResponseMessage;
import com.neo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //更新订单
    //state 的值为0/1, 0 代表完善订单操作，1 代表更新订单操作
    @RequestMapping(path = "/order",method = RequestMethod.PUT)
    public ResponseMessage updateOrder(@RequestBody Order order,@RequestParam(value = "state")Integer state) {
        //完善订单，添加 FEE（费用） 和 WEIGHT（重量）
        if(state==0){
            if(orderMapper.perfectOrder(order)==1){
                return new ResponseMessage<>(null).success();
            }
            return new ResponseMessage<>(null).error(202,"fail to perfect order");
        }
        //更新订单，更新状态
        else{
            if(orderMapper.updateOrder(order)==1){
                return new ResponseMessage<>(null).success();
            }
            return new ResponseMessage<>(null).error(202,"fail to update order");
        }
    }


    //查看订单
    @RequestMapping(path = "/order",method = RequestMethod.GET)
    public ResponseMessage getOrder(@RequestParam(value = "ACCOUNT_ID",required = false)Long account_id){
        List<Order> orders=orderMapper.getOrder(account_id);
        return new ResponseMessage<>(orders).success();
    }

}
