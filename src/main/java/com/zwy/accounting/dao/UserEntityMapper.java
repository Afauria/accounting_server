package com.zwy.accounting.dao;

import com.zwy.accounting.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserEntityMapper {

    String isExist(String phonenum);

    int insert(UserEntity record);

    List<UserEntity> selectUsers();

    UserEntity queryUser(UserEntity userEntity);
}