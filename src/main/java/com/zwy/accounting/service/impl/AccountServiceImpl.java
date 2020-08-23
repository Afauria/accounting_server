package com.zwy.accounting.service.impl;

import com.zwy.accounting.dao.AccountEntityMapper;
import com.zwy.accounting.entity.AccountEntity;
import com.zwy.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Afauria on 2019/1/22.
 */
//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountEntityMapper accountMapper;//这里会报错，但是并不会影响


    @Override
    public String addAccount(AccountEntity accountEntity) {
        String accountId = UUID.randomUUID().toString().replace("-", "");
        accountEntity.setAccountId(accountId);
        int result = accountMapper.insert(accountEntity);
        if(result == 1) return accountEntity.getAccountId();
        return null;
    }

    @Override
    public List<AccountEntity> queryAllAccountByUserId(String userid) {
        return accountMapper.selectAllByUserId(userid);
    }

    @Override
    public int deleteByAccountId(String accountId) {
        return accountMapper.deleteByAccountId(accountId);
    }

    @Override
    public int updateByAccountId(AccountEntity accountEntity) {
        return accountMapper.updateByAccountId(accountEntity);
    }
}
