package com.neo.web;

import com.neo.entity.Account;
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
    public List<Account> getAllAccounts(){
        return accountMapper.getAllAccounts();
    }
}
