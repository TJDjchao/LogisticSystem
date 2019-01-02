package com.neo.controller;

import com.neo.entity.Location;
import com.neo.entity.ResponseMessage;
import com.neo.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationMapper locationMapper;

    //添加地址
    @RequestMapping(path = "/location",method = RequestMethod.POST)
    public ResponseMessage addNewLocation(@RequestBody Location location){
        if(locationMapper.addNewLocation(location)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to add address");
    }

    //修改地址
    @RequestMapping(path = "/location",method = RequestMethod.PUT)
    public ResponseMessage changeLocation(@RequestBody Location location){
        if(locationMapper.changeLocation(location)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to change location");
    }

    //删除地址
    @RequestMapping(path = "/location",method = RequestMethod.DELETE)
    public ResponseMessage deleteLocation(@RequestBody Location location){
        if(locationMapper.deleteLocation(location)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to delete location");
    }

    //得到地址
    @RequestMapping(path = "/location",method = RequestMethod.GET)
    public ResponseMessage getLocation(@RequestParam(value = "ACCOUNT_ID",required = false)long account_id){
            List<Location> locations=locationMapper.getLocation(account_id);
            return new ResponseMessage<>(locations).success();
    }

}

