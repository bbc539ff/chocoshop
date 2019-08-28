package com.chocoshop.mapper;

import com.chocoshop.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CategoryMapper extends tk.mybatis.mapper.common.Mapper<Category>  {
}