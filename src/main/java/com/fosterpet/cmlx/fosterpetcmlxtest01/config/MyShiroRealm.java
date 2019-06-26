package com.fosterpet.cmlx.fosterpetcmlxtest01.config;

import com.fosterpet.cmlx.fosterpetcmlxtest01.message.model.SysPermission;
import com.fosterpet.cmlx.fosterpetcmlxtest01.message.model.SysRole;
import com.fosterpet.cmlx.fosterpetcmlxtest01.message.model.UserInfo;
import com.fosterpet.cmlx.fosterpetcmlxtest01.service.UserInfoService;
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

/**
 * @Author cmlx
 * @Date 2019-6-25 0025 20:42
 * @Version 1.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置--》MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        for (SysRole role:userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p:role.getPermissions()) {
               authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /* 主要用来做身份验证的，验证用户输入的账号和密码是否正确 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户输入的账号
        String username = (String) authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        //通过username从数据库中查找User对象
        //实际项目中，可以根据实际情况做缓存，如果不做，Shiro自己也是有时间限制的，2分钟之内不会重复执行此方法
        UserInfo userInfo = userInfoService.findByUsername(username);
        System.out.println("--------->>userInfo="+userInfo);
        if (userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo,//用户名
                userInfo.getPassword(),//密码
                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()//real name
                );
        return authenticationInfo;
    }
}
