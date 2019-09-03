package com.chocoshop.mapper;

import com.chocoshop.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper extends tk.mybatis.mapper.common.Mapper<Goods> {
    @Select("<script>" +
            "SELECT * FROM cc_goods " +
            "<where>" +
            "<if test=\"goodsId != null\">" +
            "goods_id = #{goodsId}" +
            "</if>" +
            "<if test=\"goodsTitle != null\">" +
            "AND goods_title = #{goodsTitle}" +
            "</if>" +
            "<if test=\"categoryId != null\">" +
            "AND category_id = #{categoryId}" +
            "</if>" +
            "<if test=\"goodsPrice != null\">" +
            "goods_id = #{goodsPrice}" +
            "</if>" +
            "<if test=\"goodsNumber != null\">" +
            "AND goods_number = #{goodsNumber}" +
            "</if>" +
            "<if test=\"goodsImageurl != null\">" +
            "AND goods_imageurl = #{goodsImageurl}" +
            "</if>" +
            "<if test=\"goodsStatus != null\">" +
            "goods_status = #{goodsStatus}" +
            "</if>" +
            "<if test=\"goodsCreateTime != null\">" +
            "AND goods_create_time = #{goodsCreateTime}" +
            "</if>" +
            "<if test=\"goodsUpdateTime != null\">" +
            "AND goods_update_time = #{goodsUpdateTime}" +
            "</if>" +
            "<if test=\"goodsDetail != null\">" +
            "AND goods_detail = #{goodsDetail}" +
            "</if>" +
            "<if test=\"goodsDetailImageurl != null\">" +
            "AND goods_detail_imageurl = #{goodsDetailImageurl}" +
            "</if>" +
            "</where>" +
            "</script>")
    @Results({
            @Result(property = "goodsId", column = "goods_id"),
            @Result(property = "goodsTitle", column = "goods_title"),
            @Result(property = "categoryId", column = "category_id"),
            @Result(property = "goodsPrice", column = "goods_price"),
            @Result(property = "goodsNumber", column = "goods_number"),
            @Result(property = "goodsImageurl", column = "goods_imageurl"),
            @Result(property = "goodsStatus", column = "goods_status"),
            @Result(property = "goodsCreateTime", column = "goods_create_time"),
            @Result(property = "goodsUpdateTime", column = "goods_update_time"),
            @Result(property = "goodsDetail", column = "goods_detail"),
            @Result(property = "goodsDetailImageurl", column = "goods_detail_imageurl"),
    })
    List<Goods> search(Goods goods);
}
