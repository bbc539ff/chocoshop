package com.chocoshop.mapper;

import com.chocoshop.model.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper extends tk.mybatis.mapper.common.Mapper<Admin> {


    @Select("SELECT * FROM cc_admin WHERE admin_name = #{adminName}")
    @Results({
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "adminName", column = "admin_name"),
            @Result(property = "adminNickname", column = "admin_nickname"),
            @Result(property = "adminPassword", column = "admin_password"),
            @Result(property = "adminSalt", column = "admin_salt"),
            @Result(property = "adminState", column = "admin_state"),
            @Result(property = "adminPhone", column = "admin_phone"),
            @Result(property = "adminEmail", column = "admin_email"),
            @Result(property = "adminCreateTime", column = "admin_create_time"),
            @Result(property = "adminUpdateTime", column = "admin_update_time"),
            @Result(property = "adminGender", column = "admin_gender"),
            @Result(property = "adminAddress", column = "admin_address"),
            @Result(property = "adminPhoto", column = "admin_photo"),
            @Result(property = "roleList", column = "admin_id", many = @Many(select = "com.chocoshop.mapper.SysRoleMapper.selectByAdminId"))
    })
    Admin findByAdminName(@Param("adminName") String adminName);

    @Select("<script>" +
            "SELECT * FROM cc_admin " +
            "<where>" +
            "<if test=\"adminId != null\">" +
            "admin_id = #{adminId}" +
            "</if>" +
            "<if test=\"adminName != null\">" +
            "AND admin_name = #{adminName}" +
            "</if>" +
            "<if test=\"adminNickname != null\">" +
            "AND admin_nickname = #{adminNickname}" +
            "</if>" +
            "<if test=\"adminState != null\">" +
            "AND admin_state = #{adminState}" +
            "</if>" +
            "<if test=\"adminPhone != null\">" +
            "AND admin_phone = #{adminPhone}" +
            "</if>" +
            "<if test=\"adminEmail != null\">" +
            "AND admin_email = #{adminEmail}" +
            "</if>" +
            "<if test=\"adminCreateTime != null\">" +
            "AND admin_create_time = #{adminCreateTime}" +
            "</if>" +
            "<if test=\"adminUpdateTime != null\">" +
            "AND admin_update_time = #{adminUpdateTime}" +
            "</if>" +
            "<if test=\"adminGender != null\">" +
            "AND admin_gender = #{adminGender}" +
            "</if>" +
            "<if test=\"adminAddress != null\">" +
            "AND admin_address = #{adminAddress}" +
            "</if>" +
            "</where>" +
            "</script>")
    @Results({
            @Result(property = "adminId", column = "admin_id"),
            @Result(property = "adminName", column = "admin_name"),
            @Result(property = "adminNickname", column = "admin_nickname"),
            @Result(property = "adminState", column = "admin_state"),
            @Result(property = "adminPhone", column = "admin_phone"),
            @Result(property = "adminEmail", column = "admin_email"),
            @Result(property = "adminCreateTime", column = "admin_create_time"),
            @Result(property = "adminUpdateTime", column = "admin_update_time"),
            @Result(property = "adminGender", column = "admin_gender"),
            @Result(property = "adminAddress", column = "admin_address"),
    })
    List<Admin> search(Admin admin);

}
