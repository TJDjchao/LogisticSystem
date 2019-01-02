package com.neo.controller;

import com.neo.entity.ResponseMessage;
import com.neo.mapper.TransportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;



@RestController
public class TransportController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    TransportMapper transportMapper;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }


    //查看订单
    @RequestMapping(path = "/transport",method = RequestMethod.GET)
    public ResponseMessage getReport(@RequestParam(value = "SITE_1_ID",required = false)Long SITE_1_ID,
                                     @RequestParam(value = "SITE_2_ID",required = false) Long SITE_2_ID,
                                     @RequestParam(value = "WEIGHT",required = false) Long WEIGHT){
        Long cost=WEIGHT*8;
        return new ResponseMessage<>(cost).success();
    }

}
