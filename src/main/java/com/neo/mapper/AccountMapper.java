package com.neo.mapper;

import com.neo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMapper {
    @Select("SELECT * FROM ACCOUNT")
    List<Account> getAllAccounts();
}
