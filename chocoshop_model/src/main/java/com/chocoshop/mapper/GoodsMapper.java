package com.chocoshop.mapper;

import com.chocoshop.model.Goods;
import org.apache.ibatis.annotations.*;

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
            "AND goods_title LIKE CONCAT('%', #{goodsTitle}, '%')" +
            "</if>" +
            "<if test=\"categoryId != null\">" +
            "AND category_id = #{categoryId}" +
            "</if>" +
            "<if test=\"goodsPrice != null\">" +
            "goods_price = #{goodsPrice}" +
            "</if>" +
            "<if test=\"goodsNumber != null\">" +
            "AND goods_number = #{goodsNumber}" +
            "</if>" +
            "<if test=\"goodsImageurl != null\">" +
            "AND goods_imageurl LIKE CONCAT('%', #{goodsImageurl}, '%')" +
            "</if>" +
            "<if test=\"goodsStatus != null\">" +
            "goods_status = #{goodsStatus}" +
            "</if>" +
            "<if test=\"goodsCreateTime != null\">" +
            "AND DATE_FORMAT(goods_create_time, '%Y-%m-%d') =  DATE_FORMAT(#{goodsCreateTime}, '%Y-%m-%d')" +
            "</if>" +
            "<if test=\"goodsUpdateTime != null\">" +
            "AND DATE_FORMAT(goods_update_time, '%Y-%m-%d') =  DATE_FORMAT(#{goodsUpdateTime}, '%Y-%m-%d')" +
            "</if>" +
            "<if test=\"goodsDetail != null\">" +
            "AND goods_detail LIKE CONCAT('%', #{goodsDetail}, '%')" +
            "</if>" +
            "<if test=\"goodsDetailImageurl != null\">" +
            "AND goods_detail_imageurl LIKE CONCAT('%', #{goodsDetailImageurl}, '%')" +
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

    @Insert("INSERT INTO cc_goods " +
            "(goods_title, category_id, goods_price, goods_number, goods_imageurl, goods_status, goods_create_time, goods_update_time, goods_detail, goods_detail_imageurl) " +
            "VALUES(#{goodsTitle}, #{categoryId}, #{goodsPrice}, #{goodsNumber}, #{goodsImageurl}, #{goodsStatus}, #{goodsCreateTime}, #{goodsUpdateTime}, #{goodsDetail}, #{goodsDetailImageurl})")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="goodsId", before=false, resultType=Long.class)
    Long insertGoods(Goods goods);
}
