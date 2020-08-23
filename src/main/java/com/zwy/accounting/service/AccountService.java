package com.zwy.accounting.service;

import com.zwy.accounting.entity.AccountEntity;

import java.util.List;

public interface AccountService {

    String addAccount(AccountEntity accountEntity);

    List<AccountEntity> queryAllAccountByUserId(String userid);

    int deleteByAccountId(String accountId);

    int updateByAccountId(AccountEntity accountEntity);
}
