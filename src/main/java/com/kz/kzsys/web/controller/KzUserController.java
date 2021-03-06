package com.kz.kzsys.web.controller;


import com.kz.kzsys.core.common.ServerResponse;
import com.kz.kzsys.mapper.KzUserMapper;
import com.kz.kzsys.model.KzUser;
import com.kz.kzsys.service.KzUserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/user")
public class KzUserController {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfiguration.class);

    @Autowired
    private KzUserServiceImpl kzUserServiceImpl;

    @RequestMapping("/listSingleton")
    public List<KzUser> findByName(String username){

        return kzUserServiceImpl.findByName(username);
    }
    @GetMapping(value = "/login")
    @ResponseBody
    public ServerResponse<String> login(String userName, String password, RedirectAttributes model) {
        // 想要得到 SecurityUtils.getSubject() 的对象．．
        // 访问地址必须跟 shiro 的拦截地址内．不然后会报空指针
        Subject sub = SecurityUtils.getSubject();
        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
        // 认证执行者交由 com.battcn.config.AuthRealm 中 doGetAuthenticationInfo 处理
        // 当以上认证成功后会向下执行,认证失败会抛出异常
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            sub.login(token);
        } catch (UnknownAccountException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", userName);
            token.clear();
            return ServerResponse.createByErrorMessage("UnknownAccountException") ;
        } catch (LockedAccountException lae) {
            log.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", userName);
            token.clear();
            return ServerResponse.createByErrorMessage("LockedAccountException");
        } catch (ExcessiveAttemptsException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", userName);
            token.clear();
            return ServerResponse.createByErrorMessage("ExcessiveAttemptsException");
        } catch (AuthenticationException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", userName, e);
            token.clear();
            return ServerResponse.createByErrorMessage("AuthenticationException");
        }
        return ServerResponse.createBySuccessMessage("登陆成功....");
    }

    @GetMapping(value = "/denied")
    public String denied() {
        log.info("小伙子权限不足,别无谓挣扎了...");
        return "denied...";
    }

}
