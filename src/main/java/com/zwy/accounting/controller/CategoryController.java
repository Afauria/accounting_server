package com.zwy.accounting.controller;

import com.zwy.accounting.entity.CategoryEntity;
import com.zwy.accounting.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/add")
    public String addUser(@RequestBody CategoryEntity categoryEntity) {
        return categoryService.addCategory(categoryEntity);
    }

    @GetMapping("/all")
    public Object queryAllAccountByUserId(@RequestParam("userid") String userid) {
        return categoryService.queryAllByUserId(userid);
    }

    @PostMapping("/update")
    public Object updateAmountByAccountId(@RequestBody CategoryEntity categoryEntity) {
        return categoryService.updateByCategoryId(categoryEntity);
    }


    @PostMapping("/delete")
    public int deleteByAccountId(@RequestParam("categoryid") String accountid) {
        return categoryService.deleteByCategoryId(accountid);
    }
}
