package com.zwy.accounting.service;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    Result addCategory(String userid, List<CategoryEntity> categoryEntities);

    Result queryCategoryByCondition(CategoryEntity categoryEntity);

    Result updateByCategoryId(CategoryEntity categoryEntity);

    Result deleteByCategoryId(String userid, String categoryId);
}
