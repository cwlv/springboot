package com.springboot.shiro;

import com.springboot.entity.PermissionEntity;
import com.springboot.entity.UserEntity;
import com.springboot.service.LoginService;
import com.springboot.service.PermissionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.Iterator;
import java.util.List;

public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String user_name = token.getUsername();
        String password = new String(token.getPassword());
        UserEntity user = null;
        try {
            user = this.loginService.login(user_name,password);
        } catch (Exception e) {
            log.info("对用户[" + token.getUsername() + "]进行登录验证..验证未通过：{}", e.getMessage());
            throw new AccountException(e.getMessage());
        }
        return new SimpleAuthenticationInfo(user, token.getPassword(), getName());
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("————权限配置————");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserEntity user = (UserEntity) principalCollection.getPrimaryPrincipal();
        List<PermissionEntity> permissions = this.permissionService.listPermission(user);
        for(PermissionEntity permission : permissions){
            authorizationInfo.addRole(permission.getRole_type());
            authorizationInfo.addStringPermission(permission.getPerms());
        }
        return authorizationInfo;
    }


    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex(("admin" + "admin123").getBytes()));
    }
}
