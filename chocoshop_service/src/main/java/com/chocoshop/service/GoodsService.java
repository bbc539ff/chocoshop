package com.chocoshop.service;

import com.chocoshop.mapper.CategoryMapper;
import com.chocoshop.mapper.GoodsMapper;
import com.chocoshop.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import utils.Utils;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public List<Goods> showAllGoods(){
        return goodsMapper.selectAll();
    }

    public int addGoods(Goods goods, MultipartFile[] files) {
        goodsMapper.insert(goods);
        Long goodsId = goodsMapper.selectOne(goods).getGoodsId();
        String path = "";
        for(int i = 0;i<files.length;i++) {
            path += Utils.uploadSingle(files[i], "/upload/goods/"+goodsId+"/", Integer.toString(i))+", ";
        }
        goods.setGoodsImageurl(path);

        System.out.println(goods);
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public int deleteGoods(Goods goods){
        return goodsMapper.delete(goods);
    }

    public int updateGoods(Goods goods, MultipartFile[] files){
        Long goodsId = goods.getGoodsId();
        String path = "";
        for(int i = 0;i<files.length;i++) {
            path += Utils.uploadSingle(files[i], "/upload/goods/"+goodsId, Integer.toString(i))+", ";
        }
        goods.setGoodsImageurl(path);

        System.out.println(goods);

        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public List<Goods> search(Goods goods){
        try {
            return goodsMapper.search(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int countGoods(){
        return goodsMapper.selectCount(new Goods());
    }
}
