package com.kz.kzsys.config;

import com.kz.kzsys.mapper.KzUserMapper;
import com.kz.kzsys.model.KzUser;
import com.kz.kzsys.service.KzUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by mr.chan on 2018/9/3.
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private KzUserMapper kzUserMapper;
    /**
     * 登陆验证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //得到用户名
        String principal = (String) token.getPrincipal();
        //从数据库中查询用户
        KzUser kzUser = kzUserMapper.findByName(principal);
        //System.out.printf("数据库密码:"+kzUser.getPassword()+"\t用户密码："+token.getCredentials()+"\t\t\t\t"+kzUser.getSalt());

        //////////////////////////////////////////////////////////
        // 如果使用 HashedCredentialsMatcher 这里认证方式就要改一下
        // TODO 后期改进：md5+盐
        ////////////////////////////////////////////////////////
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, kzUser.getPassword(), ByteSource.Util.bytes(kzUser.getSalt()), getName());

        //////////////////////////////////////
        //明文密码下面这个方法
        //////////////////////////////////////
        //  SimpleAuthenticationInfo authenticationInfo = new  SimpleAuthenticationInfo(principal, kzUser.getPassword(), getName());
        //将用户名存入session,交给shiro管理
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", kzUser);
        return authenticationInfo;
    }
    /**
     * 权限管理
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Session session = SecurityUtils.getSubject().getSession();
        KzUser user = (KzUser) session.getAttribute("USER_SESSION");
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // TODO　还未加入权限功能：用户的角色集合
        // 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面可以不要
        // 只有角色并没有颗粒度到每一个按钮 或 是操作选项  PERMISSIONS 是可选项
        return info;
    }


}
