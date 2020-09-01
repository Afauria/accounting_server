package com.zwy.accounting.dao;

import com.zwy.accounting.entity.CategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryEntityMapper {

    int insert(List<CategoryEntity> categoryEntities);

    List<CategoryEntity> selectByCondition(CategoryEntity categoryEntity);

    int updateByCategoryId(CategoryEntity categoryEntity);

    int deleteByCategoryId(@Param("creator") String creator, @Param("categoryId") String categoryId);

    String isExist(String name);

}