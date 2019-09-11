package com.chocoshop.realm.user;

import com.chocoshop.model.Member;
import com.chocoshop.model.SysPermission;
import com.chocoshop.model.SysRole;
import com.chocoshop.service.MemberService;
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

public class UserLoginRealm extends AuthorizingRealm {
    @Resource
    private MemberService memberService;

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String memberUserName = (String)token.getPrincipal();

        Member member = memberService.findByMemberName(memberUserName);
        if(member == null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                member, //用户名
                member.getMemberPassword(), //密码
                ByteSource.Util.bytes(member.getMemberSalt()),
                getName()  //realm name
        );
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
