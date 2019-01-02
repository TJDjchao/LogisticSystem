package com.neo.controller;

import com.neo.entity.ResponseMessage;
import com.neo.entity.*;
import com.neo.mapper.SiteRouteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SiteRouteController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    SiteRouteMapper siteRouteMapper;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    //新增站点
    @RequestMapping(path = "/site",method = RequestMethod.POST)
    public ResponseMessage addNewSite(@RequestBody Site site){
        if(siteRouteMapper.addNewSite(site)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to add new site");
    }

    //查询站点
    @RequestMapping(path = "/site",method = RequestMethod.GET)
    public ResponseMessage searchSite(@RequestParam(value = "KEY",required = false)String KEY){
        List<Site> sites=siteRouteMapper.searchSite(KEY);
        return new ResponseMessage<>(sites).success();
    }

    //更改站点
    @RequestMapping(path = "/site",method = RequestMethod.PUT)
    public ResponseMessage changeSite(@RequestBody Site site) {
        if (siteRouteMapper.changeSite(site) == 1) {
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202, "fail to change site");
    }

    //删除站点
    @RequestMapping(path = "/site",method = RequestMethod.DELETE)
    public ResponseMessage deleteSite(@RequestParam(value = "SITE_ID",required = false)Long SITE_ID){
        if (siteRouteMapper.deleteSite(SITE_ID) == 1) {
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202, "fail to delete site");
    }

    //新增路线
    @RequestMapping(path = "/route",method = RequestMethod.POST)
    public ResponseMessage addNewRoute(@RequestBody Route route){
        if(siteRouteMapper.addNewRoute(route)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to add new route");
    }

    //删除路线

    @RequestMapping(path = "/route",method = RequestMethod.DELETE)
    public ResponseMessage deleteRoute(@RequestParam(value = "SITE_1_ID",required = false)Long SITE_1_ID,@RequestParam(value = "SITE_2_ID",required = false)Long SITE_2_ID){
        if (siteRouteMapper.deleteRoute(SITE_1_ID,SITE_2_ID) == 1) {
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202, "fail to delete route");
    }
}
