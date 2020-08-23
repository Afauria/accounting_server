package com.zwy.accounting.dao;

import com.zwy.accounting.entity.CategoryEntity;

import java.util.List;

public interface CategoryEntityMapper {

    int insert(CategoryEntity categoryEntity);

    int deleteByCategoryId(String categoryId);

    List<CategoryEntity> selectAllByUserId(String userId);

    int updateByCategoryId(CategoryEntity categoryEntity);

}