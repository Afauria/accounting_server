package com.zwy.accounting.controller;

import com.alibaba.fastjson.JSONArray;
import com.zwy.accounting.entity.AccountEntity;
import com.zwy.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public Object addAccount(@RequestHeader(value = "userid", required = true) String userid, @RequestBody String jsonString) {
        List<AccountEntity> accountEntities = JSONArray.parseArray(jsonString, AccountEntity.class);
        return accountService.addAccount(userid, accountEntities);
    }

    @PostMapping("/query")
    public Object queryAccountByCondition(@RequestHeader(value = "userid", required = true) String userid, @RequestBody AccountEntity accountEntity) {
        accountEntity.setCreator(userid);
        return accountService.queryAccountByCondition(accountEntity);
    }

    @PostMapping("/update")
    public Object updateAmountByAccountId(@RequestHeader(value = "userid", required = true) String userid, @RequestBody AccountEntity accountEntity) {
        return accountService.updateByAccountId(accountEntity);
    }


    @PostMapping("/delete")
    public Object deleteByAccountId(@RequestHeader(value = "userid", required = true) String userid,  @RequestBody AccountEntity accountEntity) {
        return accountService.deleteByAccountId(userid, accountEntity.getAccountId());
    }
}

