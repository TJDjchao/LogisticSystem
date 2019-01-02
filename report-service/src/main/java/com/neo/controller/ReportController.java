package com.neo.controller;

import com.neo.entity.Order;
import com.neo.entity.ResponseMessage;
import com.neo.mapper.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.text.*;

@RestController
public class ReportController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    ReportMapper reportMapper;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }


    //查看订单
    @RequestMapping(path = "/report",method = RequestMethod.GET)
    public ResponseMessage getReport(@RequestParam(value = "TIME_BEGIN",required = false)String TIME_BEGIN,@RequestParam(value = "TIME_END",required = false) String TIME_END){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try{
            Date dt1 = df.parse(TIME_BEGIN);//将字符串转换为date类型
            Date dt2 = df.parse(TIME_END);
            List<Order> orders= reportMapper.getReport(dt1,dt2);
            return new ResponseMessage<>(orders).success();
        }
        catch(Exception e){
            System.out.println("Wrong!");
            return new ResponseMessage<>(null).error(202,"fail to get report");
        }
    }

}
