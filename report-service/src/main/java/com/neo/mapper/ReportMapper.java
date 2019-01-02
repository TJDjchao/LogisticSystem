package com.neo.mapper;

import com.neo.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ReportMapper {

    //查看订单
    @Select("SELECT * FROM BILL WHERE TIME >= #{TIME_BEGIN} AND TIME <=#{TIME_END} ORDER BY TIME desc")
    List<Order> getReport(@Param(value = "TIME_BEGIN") Date TIME_BEGIN,@Param(value = "TIME_END") Date TIME_END);

}
