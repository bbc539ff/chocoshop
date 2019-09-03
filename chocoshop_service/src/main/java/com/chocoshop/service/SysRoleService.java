package com.chocoshop.service;

import com.chocoshop.mapper.SysRoleMapper;
import com.chocoshop.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    public List<SysRole> showAllRole(){
        return sysRoleMapper.selectAll();
    }

    public int addSysRole(SysRole sysRole){
        try {
            return sysRoleMapper.insert(sysRole);
        } catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteSysRole(SysRole sysRole){
        return sysRoleMapper.delete(sysRole);
    }

    public int updateSysRole(SysRole sysRole){
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    public List<SysRole> search(SysRole sysRole){
        try {
            return sysRoleMapper.search(sysRole);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
