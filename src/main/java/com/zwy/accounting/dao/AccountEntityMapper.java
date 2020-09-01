package com.zwy.accounting.dao;

import com.zwy.accounting.entity.AccountEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountEntityMapper {

    int insert(List<AccountEntity> record);

    List<AccountEntity> selectByCondition(AccountEntity accountEntity);

    int deleteByAccountId(@Param("creator") String creator,@Param("accountId") String accountId);

    int updateByAccountId(AccountEntity accountEntity);

    String isExist(String name);
}