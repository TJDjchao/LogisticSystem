package com.neo.controller;

import com.neo.entity.Account;
import com.neo.entity.ResponseMessage;
import com.neo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountMapper accountMapper;

    @RequestMapping(path = "/account",method = RequestMethod.GET)
    public ResponseMessage getAllAccounts(){
        List<Account> accounts=accountMapper.getAllAccounts();
        return new ResponseMessage<>(accounts).success();
    }

    //创建用户（注册）
    @RequestMapping(path = "/users",method = RequestMethod.POST)
    public ResponseMessage addNewUser(@RequestBody Account account){
        if(accountMapper.addNewUser(account)==1){
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"fail to register");
    }

    //登录
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ResponseMessage login(@RequestBody Account account) {
        if (accountMapper.login(account) == 1) {
            return new ResponseMessage<>(null).success();
        }
        return new ResponseMessage<>(null).error(202,"login failed");
    }

}
