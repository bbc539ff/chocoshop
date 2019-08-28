package com.chocoshop.service;

import com.chocoshop.mapper.UserInfoMapper;
import com.chocoshop.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo findByUsername(String username){
        return userInfoMapper.findByUsername(username);
    }

    public void createUser(UserInfo userInfo){
        userInfoMapper.insert(userInfo);
    }
    public int addUser(UserInfo userInfo){
        return userInfoMapper.insert(userInfo);
    }

    public int deleteUser(UserInfo userInfo){
        return userInfoMapper.delete(userInfo);
    }

    public int updateUser(UserInfo userInfo){
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
