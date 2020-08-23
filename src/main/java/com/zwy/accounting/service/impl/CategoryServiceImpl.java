package com.zwy.accounting.service.impl;

import com.zwy.accounting.dao.CategoryEntityMapper;
import com.zwy.accounting.entity.CategoryEntity;
import com.zwy.accounting.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryEntityMapper categoryMapper;//这里会报错，但是并不会影响

    @Override
    public String addCategory(CategoryEntity categoryEntity) {
        String id = UUID.randomUUID().toString().replace("-", "");
        categoryEntity.setCategoryId(id);
        int result = categoryMapper.insert(categoryEntity);
        if(result == 1) return id;
        return null;
    }

    @Override
    public int deleteByCategoryId(String categoryId) {
        return categoryMapper.deleteByCategoryId(categoryId);
    }

    @Override
    public List<CategoryEntity> queryAllByUserId(String userId) {
        return categoryMapper.selectAllByUserId(userId);
    }

    @Override
    public int updateByCategoryId(CategoryEntity categoryEntity) {
        return categoryMapper.updateByCategoryId(categoryEntity);
    }
}
