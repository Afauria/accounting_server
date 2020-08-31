package com.zwy.accounting.dao;

import com.zwy.accounting.entity.AccountEntity;

import java.util.List;

public interface AccountEntityMapper {

    int insert(List<AccountEntity> record);

    List<AccountEntity> selectByCondition(AccountEntity accountEntity);

    int deleteByAccountId(String accountId);

    int updateByAccountId(AccountEntity accountEntity);
}