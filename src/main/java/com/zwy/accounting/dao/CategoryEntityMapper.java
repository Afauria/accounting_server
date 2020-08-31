package com.zwy.accounting.dao;

import com.zwy.accounting.entity.CategoryEntity;

import java.util.List;

public interface CategoryEntityMapper {

    int insert(List<CategoryEntity> categoryEntities);

    List<CategoryEntity> selectByCondition(CategoryEntity categoryEntity);

    int updateByCategoryId(CategoryEntity categoryEntity);

    int deleteByCategoryId(String categoryId);

}