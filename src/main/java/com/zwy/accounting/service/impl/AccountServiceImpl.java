package com.zwy.accounting.service.impl;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import com.zwy.accounting.dao.AccountEntityMapper;
import com.zwy.accounting.entity.AccountEntity;
import com.zwy.accounting.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountEntityMapper accountMapper;//这里会报错，但是并不会影响


    @Override
    public Result addAccount(String userid, List<AccountEntity> accountEntities) {
        for (AccountEntity entity : accountEntities) {
            String id = UUID.randomUUID().toString().replace("-", "");
            entity.setAccountId(id);
            entity.setCreator(userid);
        }
        int res = accountMapper.insert(accountEntities);
        if(res > 0) {
            return ResultUtil.success(accountEntities);
        }
        return null;
    }

    @Override
    public Result queryAccountByCondition(AccountEntity accountEntity) {
        List<AccountEntity> accountEntities = accountMapper.selectByCondition(accountEntity);
        return ResultUtil.success(accountEntities);
    }

    @Override
    public Result deleteByAccountId(String userid, String accountId) {
        // TO DO
        // 校验一下accountid是不是属于该用户
        int res = accountMapper.deleteByAccountId(accountId);
        if(res > 0){
            return ResultUtil.success(null);
        }
        return ResultUtil.error(10001, "删除失败，不存在此ID");
    }

    @Override
    public Result updateByAccountId(AccountEntity accountEntity) {
        // TO DO
        // 校验一下accountid是不是属于该用户
        int res =  accountMapper.updateByAccountId(accountEntity);
        if(res > 0){
            return ResultUtil.success(null);
        }
        return ResultUtil.error(10001, "更新失败，不存在此ID");

    }
}
