package com.hp.szy.Utils;

import com.hp.szy.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTFilter;
    }


    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String loginName = JWTUtil.getUsername(token);
        if (loginName == null || !JWTUtil.verify(token,loginName )) {
            throw new AuthenticationException("token认证失败！");
        }

        /* 以下数据库查询可根据实际情况，可以不必再次查询，这里我两次查询会很耗资源
         * 我这里增加两次查询是因为考虑到数据库管理员可能自行更改数据库中的用户信息
         */
//        String password = userService.getPassword(loginName);
        String password =userService.getPassword(loginName);
        if (password == null) {
            throw new AuthenticationException("该用户不存在！");
        }
        int ban = userService.checkUserBanStatus(loginName);
        if (ban == 1) {
            throw new AuthenticationException("该用户已被封号！");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("————权限认证————");

        String loginName = JWTUtil.getUsername(principals.toString());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = userService.getRole(loginName);
        //每个角色拥有默认的权限
        String rolePermission = userService.getRolePermission(loginName);
        //每个用户可以设置新的权限
        String permission = userService.getPermission(loginName);

        Set<String> roleSet = new HashSet<>();

        Set<String> permissionSet = new HashSet<>();
        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
        roleSet.add(role);
        permissionSet.add(rolePermission);
        permissionSet.add(permission);
        //设置该用户拥有的角色和权限
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        return info;

    }




}
