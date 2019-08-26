package com.chocoshop.mapper;

import com.chocoshop.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoMapper {

    /**
     * 根据用户名获取信息。
     * @param username 管理员的用户名
     * @return UserInfo 类
     */
    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo findByUsername(@Param("username") String username);

}
