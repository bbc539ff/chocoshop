package com.chocoshop.service;

import com.chocoshop.mapper.GoodsMapper;
import com.chocoshop.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    public GoodsMapper goodsMapper;

    public List<Goods> showAllGoods(){
        return goodsMapper.selectAll();
    }

    public int addGoods(Goods goods){
        return goodsMapper.insert(goods);
    }

    public int deleteGoods(Goods goods){
        return goodsMapper.delete(goods);
    }

    public int updateGoods(Goods goods){
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

}
