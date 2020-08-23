package com.zwy.accounting.service;

import com.zwy.accounting.entity.AccountEntity;
import com.zwy.accounting.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    String addCategory(CategoryEntity categoryEntity);

    int deleteByCategoryId(String categoryId);

    List<CategoryEntity> queryAllByUserId(String userId);

    int updateByCategoryId(CategoryEntity categoryEntity);
}
