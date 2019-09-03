package com.chocoshop.mapper;

import com.chocoshop.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper extends tk.mybatis.mapper.common.Mapper<Member> {
    @Select("<script>" +
            "SELECT * FROM cc_member " +
            "<where>" +
            "<if test=\"memberUuid != null\">" +
            "member_uuid = #{memberUuid}" +
            "</if>" +
            "<if test=\"memberUserName != null\">" +
            "AND member_user_name = #{memberUserName}" +
            "</if>" +
            "<if test=\"memberPhone != null\">" +
            "AND member_phone = #{memberPhone}" +
            "</if>" +
            "<if test=\"memberEmail != null\">" +
            "member_email = #{memberEmail}" +
            "</if>" +
            "<if test=\"memberCreateTime != null\">" +
            "AND member_create_time = #{memberCreateTime}" +
            "</if>" +
            "<if test=\"memberUpdateTime != null\">" +
            "AND member_update_time = #{memberUpdateTime}" +
            "</if>" +
            "<if test=\"memberGender != null\">" +
            "member_gender = #{memberGender}" +
            "</if>" +
            "<if test=\"memberAddress != null\">" +
            "AND member_address = #{memberAddress}" +
            "</if>" +
            "<if test=\"memberState != null\">" +
            "AND member_state = #{memberState}" +
            "</if>" +
            "<if test=\"memberImageurl != null\">" +
            "AND member_imageurl = #{memberImageurl}" +
            "</if>" +
            "<if test=\"memberBalance != null\">" +
            "AND member_balance = #{memberBalance}" +
            "</if>" +
            "</where>" +
            "</script>")
    @Results({
            @Result(property = "memberUuid", column = "member_uuid"),
            @Result(property = "memberUserName", column = "member_user_name"),
            @Result(property = "memberPhone", column = "member_phone"),
            @Result(property = "memberEmail", column = "member_email"),
            @Result(property = "memberCreateTime", column = "member_create_time"),
            @Result(property = "memberUpdateTime", column = "member_update_time"),
            @Result(property = "memberGender", column = "member_gender"),
            @Result(property = "memberAddress", column = "member_address"),
            @Result(property = "memberState", column = "member_state"),
            @Result(property = "memberImageurl", column = "member_imageurl"),
            @Result(property = "memberBalance", column = "member_balance"),
    })
    List<Member> search(Member member);
}
