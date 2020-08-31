package com.zwy.accounting.controller;

import com.alibaba.fastjson.JSONArray;
import com.zwy.accounting.entity.CategoryEntity;
import com.zwy.accounting.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public Object addCategory(@RequestHeader(value = "userid", required = true) String userid, @RequestBody String jsonString) {
        List<CategoryEntity> categoryEntities = JSONArray.parseArray(jsonString, CategoryEntity.class);
        return categoryService.addCategory(userid, categoryEntities);
    }

    @PostMapping("/query")
    public Object queryCategoryByCondition(@RequestHeader(value = "userid", required = true) String userid, @RequestBody CategoryEntity categoryEntity) {
        categoryEntity.setCreator(userid);
        return categoryService.queryCategoryByCondition(categoryEntity);
    }

    @PostMapping("/update")
    public Object updateByCategoryId(@RequestHeader(value = "userid", required = true) String userid, @RequestBody CategoryEntity categoryEntity) {
        categoryEntity.setCreator(userid);
        return categoryService.updateByCategoryId(categoryEntity);
    }


    @PostMapping("/delete")
    public Object deleteByCategoryId(@RequestHeader(value = "userid", required = true) String userid, @RequestBody CategoryEntity categoryEntity) {
        return categoryService.deleteByCategoryId(userid, categoryEntity.getCategoryId());
    }
}
