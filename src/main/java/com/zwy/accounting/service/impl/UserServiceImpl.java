package com.zwy.accounting.service.impl;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import com.zwy.accounting.dao.UserEntityMapper;
import com.zwy.accounting.entity.UserEntity;
import com.zwy.accounting.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public Result addUser(UserEntity user) {
        if(! StringUtils.isEmpty(userMapper.isExist(user.getPhonenum()))) {
            return ResultUtil.error(10003,"用户已存在！");
        }

        String id = UUID.randomUUID().toString().replace("-", "");
        user.setUserId(id);
        int res = userMapper.insert(user);
        if(res > 0) {
            return ResultUtil.success(user);
        }
        return ResultUtil.error(10002,"新增用户失败！");
    }

    @Override
    public List<UserEntity> findAllUser() {
        List<UserEntity> users = userMapper.selectUsers();
        return users;
    }

    @Override
    public Result queryUser(UserEntity user) {
        UserEntity userEntity = userMapper.queryUser(user);
        if(userEntity != null){
            return ResultUtil.success(userEntity);
        }
        return ResultUtil.error(10004, "不存在此用户！");
    }
}
