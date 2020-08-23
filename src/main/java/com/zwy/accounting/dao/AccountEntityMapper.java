package com.zwy.accounting.dao;

import com.zwy.accounting.entity.AccountEntity;

import java.util.List;

public interface AccountEntityMapper {

    int insert(AccountEntity record);

    List<AccountEntity> selectAllByUserId(String userid);

    int deleteByAccountId(String accountId);

    int updateByAccountId(AccountEntity accountEntity);
}