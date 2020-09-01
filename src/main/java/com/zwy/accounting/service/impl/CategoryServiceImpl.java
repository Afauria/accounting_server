package com.zwy.accounting.service.impl;

import com.zwy.accounting.common.model.Result;
import com.zwy.accounting.common.utils.ResultUtil;
import com.zwy.accounting.dao.CategoryEntityMapper;
import com.zwy.accounting.entity.CategoryEntity;
import com.zwy.accounting.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

//修饰service组件,加上之后可以使用@AutoWired自动导入,value值唯一,否则会报错
//@Service和@Controller与@Component等效,只不过用名称区分控制层和业务层
@Service(value = "categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryEntityMapper categoryMapper;//这里会报错，但是并不会影响

    @Override
    public Result addCategory(String userid, List<CategoryEntity> categoryEntities) {
        for (CategoryEntity entity : categoryEntities) {
            if(! StringUtils.isEmpty(categoryMapper.isExist(entity.getName()))){
                return ResultUtil.error(10006, "新增失败，已存在:" + entity.getName());
            }
            String id = UUID.randomUUID().toString().replace("-", "");
            entity.setCategoryId(id);
            entity.setCreator(userid);
        }
        int res = categoryMapper.insert(categoryEntities);
        if(res > 0) {
            return ResultUtil.success(categoryEntities);
        }
        return null;
    }

    @Override
    public Result queryCategoryByCondition(CategoryEntity categoryEntity) {
        List<CategoryEntity> categoryEntities = categoryMapper.selectByCondition(categoryEntity);
        return ResultUtil.success(categoryEntities);
    }

    @Override
    public Result deleteByCategoryId(String userid, String categoryId) {
        int res = categoryMapper.deleteByCategoryId(userid, categoryId);
        if(res > 0){
            return ResultUtil.success(null);
        }
        return ResultUtil.error(10001, "删除失败，不存在此ID");
    }

    @Override
    public Result updateByCategoryId(CategoryEntity categoryEntity) {
        int res = categoryMapper.updateByCategoryId(categoryEntity);
        if(res > 0){
            return ResultUtil.success(null);
        }
        return ResultUtil.error(10001, "更新失败，不存在此ID");
    }
}
