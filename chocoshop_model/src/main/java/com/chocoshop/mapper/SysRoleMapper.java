package com.chocoshop.mapper;

import com.chocoshop.model.SysPermission;
import com.chocoshop.model.SysRole;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper extends tk.mybatis.mapper.common.Mapper<SysRole> {

    @Select("SELECT cc_sys_role.* FROM cc_sys_role, cc_sys_admin_role WHERE admin_id = #{adminId} AND cc_sys_role.role_id = cc_sys_admin_role.role_id")
    @Results({
            @Result(property ="roleId", column = "role_id"),
            @Result(property ="roleName", column = "role_name"),
            @Result(property ="roleAvailable", column = "role_available"),
            @Result(property ="roleDescription", column = "role_description"),
            @Result(property = "permissions", column = "role_id", many = @Many(select = "com.chocoshop.mapper.SysPermissionMapper.selectByRoleId")),
    })
    public List<SysRole> selectByAdminId(Long adminId);


    @Select("SELECT cc_sys_role.* FROM cc_sys_role, cc_sys_role_perms WHERE perm_id = #{permId} AND cc_sys_role.role_id = cc_sys_role_perms.role_id")
    @Results({
            @Result(property ="roleId", column = "role_id"),
            @Result(property ="roleName", column = "role_name"),
            @Result(property ="roleAvailable", column = "role_available"),
            @Result(property ="roleDescription", column = "role_description"),
            @Result(property = "permissions", column = "role_id", many = @Many(select = "com.chocoshop.mapper.SysPermissionMapper.selectByRoleId")),
    })
    public List<SysRole> selectByPermId(Integer permId);

}
