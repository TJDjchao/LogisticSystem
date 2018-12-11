package com.neo.controller;

import com.neo.entity.Account;
import com.neo.entity.ResponseMessage;
import com.neo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
}
