package com.neo.mapper;

import com.neo.entity.Location;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LocationMapper {

    //添加地址
    @Insert("INSERT INTO LOCATION(ACCOUNT_ID,NAME,PHONE,ADDRESS) VALUES(#{ACCOUNT_ID},#{NAME},#{PHONE},#{ADDRESS})")
    int addNewLocation(Location location);

    //更改地址
    @Update("UPDATE LOCATION SET ADDRESS=#{NEWADDRESS} WHERE ACCOUNT_ID=#{ACCOUNT_ID} AND NAME=#{NAME} AND PHONE=#{PHONE} AND ADDRESS=#{ADDRESS}")
    int changeLocation(Location location);

    //删除地址
    @Delete("DELETE FROM LOCATION WHERE ACCOUNT_ID=#{ACCOUNT_ID} AND NAME=#{NAME} AND PHONE=#{PHONE} AND ADDRESS=#{ADDRESS}")
    int deleteLocation(Location location);

    //得到地址
    @Select("SELECT * FROM LOCATION")
    List<Location> getLocation(@Param(value="account_id") long account_id);
}
