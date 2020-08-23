package com.zwy.accounting.controller;

import com.zwy.accounting.entity.AccountEntity;
import com.zwy.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/add")
    public String addUser(@RequestBody AccountEntity accountEntity) {
            return accountService.addAccount(accountEntity);
    }

    @GetMapping("/all")
    public Object queryAllAccountByUserId(@RequestParam("userid") String userid) {
        return accountService.queryAllAccountByUserId(userid);
    }

    @PostMapping("/update")
    public Object updateAmountByAccountId(@RequestBody AccountEntity accountEntity) {
        return accountService.updateByAccountId(accountEntity);
    }


    @PostMapping("/delete")
    public int deleteByAccountId(@RequestParam("accountid") String accountid) {
        return accountService.deleteByAccountId(accountid);
    }
}

