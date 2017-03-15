package com.calf.service;

import com.calf.entity.Category;
import com.calf.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 类别Service类
 *
 * @author calf
 * @create 2017-03-15 14:15
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category findById(long id) {
        return  categoryMapper.findById(id);
    }

    public List<Category> findAll() {
        return categoryMapper.findAll();
    }

    public int create(String name) {
        Category category = new Category();
        category.setName(name);
        category.setCreateAt(new Date());
        return  categoryMapper.insert(category);
    }

    public void update(Category category) {
        categoryMapper.update(category);
    }

    public void delete(long id) {
        categoryMapper.delete(id);
    }

}
