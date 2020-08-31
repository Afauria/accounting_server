package com.zwy.accounting.service.impl;

import com.zwy.accounting.dao.UserEntityMapper;
import com.zwy.accounting.entity.UserEntity;
import com.zwy.accounting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEntityMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserEntity user) {
        return userMapper.insert(user);
    }

    @Override
    public List<UserEntity> findAllUser() {
        List<UserEntity> users = userMapper.selectUsers();
        return users;
    }
}
