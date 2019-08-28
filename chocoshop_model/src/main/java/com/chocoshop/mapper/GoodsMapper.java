package com.chocoshop.mapper;

import com.chocoshop.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GoodsMapper extends tk.mybatis.mapper.common.Mapper<Goods> {

}
