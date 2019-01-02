package com.neo.mapper;

import com.neo.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {

    //获得所有用户信息
    @Select("SELECT * FROM ACCOUNT")
    List<Account> getAllAccounts();

    //创建用户（注册）
    @Insert("INSERT INTO ACCOUNT VALUES(#{ACCOUNT_ID}，#{PASSWORD})")
    int addNewUser(Account account);

    //登录
    @Select("SELECT COUNT( ACCOUNT_ID ) FROM ACCOUNT a WHERE ACCOUNT_ID =#{ACCOUNT_ID} AND PASSWORD = #{PASSWORD}")
    int login(Account account);

    //更改密码
    @Update("UPDATE ACCOUNT SET PASSWORD=#{PASSWORD} WHERE ACCOUNT_ID=#{ACCOUNT_ID}")
    int changePassword(Account account);

}
