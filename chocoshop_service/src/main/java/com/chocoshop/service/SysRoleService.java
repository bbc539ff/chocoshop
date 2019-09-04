package com.chocoshop.service;

import com.chocoshop.mapper.SysRoleMapper;
import com.chocoshop.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    public List<SysRole> showAllRole(){
        return sysRoleMapper.selectAll();
    }

    @Transactional
    public int addSysRole(SysRole sysRole, String permId) {
        int returnVal = 0;
        try {
            returnVal = sysRoleMapper.insert(sysRole);
            int roleId = sysRoleMapper.selectOne(sysRole).getRoleId();

            String[] perms = permId.split(",");
            for(String id : perms){
                returnVal = sysRoleMapper.insertPerm(roleId, Integer.parseInt(id.trim()));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return returnVal;
    }

    @Transactional
    public int deleteSysRole(SysRole sysRole){
        sysRoleMapper.deletePerm(sysRole.getRoleId());
        return sysRoleMapper.delete(sysRole);
    }

    @Transactional
    public int updateSysRole(SysRole sysRole, String permIds){
        int returnVal = 0;
        try {
            // 更新 Role
            returnVal = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
            int roleId = sysRole.getRoleId();

            // 先删除 roleId 下的所有权限，再插入新权限
            sysRoleMapper.deletePerm(sysRole.getRoleId());
            String[] perms = permIds.split(",");
            for(String id : perms){
                if("".equals(id.trim())) continue;
                returnVal = sysRoleMapper.insertPerm(roleId, Integer.parseInt(id.trim()));
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return returnVal;

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
