package com.chocoshop.service;

import com.chocoshop.mapper.CategoryMapper;
import com.chocoshop.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryMapper categoryMapper;

    public List<Category> getAllCategory(){
        return categoryMapper.selectAll();
    }
}
