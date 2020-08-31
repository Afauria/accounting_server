package com.zwy.accounting.service;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.entity.AccountEntity;

import java.util.List;

public interface AccountService {

    Result addAccount(String userid, List<AccountEntity> accountEntity);

    Result queryAccountByCondition(AccountEntity accountEntity);

    Result updateByAccountId(AccountEntity accountEntity);

    Result deleteByAccountId(String userid, String accountId);


}
