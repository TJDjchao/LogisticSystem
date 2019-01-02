package com.neo.mapper;

import com.neo.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Date;

@Mapper
@Repository
public interface OrderMapper {
    //查看订单
    @Select("SELECT * " +
            "FROM (BILL a NATURAL JOIN BILLSTATE b NATURAL JOIN SITE c " +
            ") WHERE ACCOUNT_ID=#{account_id} ORDER BY TIME desc")
    List<Order> getOrder(@Param(value = "account_id")Long account_id);

    //新建订单
    @Insert("INSERT INTO BILL(ACCOUNT_ID,SENDER_NAME,SENDER_PHONE,SENDER_ADDRESS,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,TIME,TYPE) VALUES(#{ACCOUNT_ID},#{SENDER_NAME},#{SENDER_PHONE},#{SENDER_ADDRESS},#{RECEIVER_NAME},#{RECEIVER_PHONE},#{RECEIVER_ADDRESS},#{TIME},#{TYPE})")
    int addNewOrder(Order order);

    //取消订单
    @Delete("UPDATE BILL SET ACCOUNT_ID=0 WHERE BILL_ID=#{bill_id}")
    int cancelOrder(@Param(value = "bill_id")Long bill_id);

    //完善订单
    @Update("UPDATE BILL SET FEE=#{FEE},WEIGHT=#{WEIGHT} WHERE BILL_ID=#{BILL_ID}")
    int perfectOrder(Order order);

    //搜索订单
    @Select("SELECT * FROM (BILL a NATURAL JOIN BILLSTATE b NATURAL JOIN SITE c ) WHERE BILL_ID=#{bill_id} ORDER BY TIME desc")
    List<Order> searchOrder(@Param(value = "bill_id")Long bill_id);

    //更新订单
    @Insert("INSERT INTO BILLSTATE VALUES(#{BILL_ID},#{SITE_ID},#{TIME},#{STATE})")
    int updateOrder(Order order);




}
