package com.chocoshop.realm;

import com.chocoshop.model.SysPermission;
import com.chocoshop.model.SysRole;
import com.chocoshop.model.Admin;
import com.chocoshop.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

public class LoginRealm extends AuthorizingRealm {
    @Resource
    private AdminService adminService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Admin admin = (Admin)principals.getPrimaryPrincipal();
        for(SysRole role: admin.getRoleList()){
            authorizationInfo.addRole(role.getRoleName());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermString());
            }
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String adminName = (String)token.getPrincipal();

        Admin admin = adminService.findByAdminName(adminName);
        System.out.println("realm:----->>adminInfo="+ admin);
        if(admin == null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                admin, //用户名
                admin.getAdminPassword(), //密码
                ByteSource.Util.bytes(admin.getAdminSalt()),
                getName()  //realm name
        );
    }

}