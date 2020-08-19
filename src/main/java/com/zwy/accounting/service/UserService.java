package com.zwy.accounting.service;

import com.github.pagehelper.PageInfo;
import com.zwy.accounting.entity.UserEntity;

import java.util.List;

/**
 * Created by Afauria on 2019/1/22.
 */
public interface UserService {
    int addUser(UserEntity user);

    List<UserEntity> findAllUser();
}
