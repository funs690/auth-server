package com.zjuici.authserver.biz.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.zjuici.authserver.biz.UpmBizService;
import com.zjuici.authserver.dao.po.ClientInfo;
import com.zjuici.authserver.dao.po.User;
import com.zjuici.authserver.service.ClientInfoService;
import com.zjuici.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UpmBizServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 18:59
 * @Version 1.0
 */
@Service
public class UpmBizServiceImpl implements UpmBizService {

    /**
     * 用户服务
     */
    @Autowired
    private UserService userService;

    /**
     * 客户端信息服务
     */
    @Autowired
    private ClientInfoService clientInfoService;


    @Override
    public SaResult login(String name, String pwd) {
        // 获取用户信息
        User user = userService.getUserByUserName(name);
        if (user == null){
            return SaResult.error("用户不存在");
        }
        if (!SaSecureUtil.sha256(pwd).equals(user.getPassword())){
            return SaResult.error("用户名密码错误");
        }
        // 用户登录
        StpUtil.login(user.getId());
        return SaResult.ok();
    }

    @Override
    public ClientInfo findClientInfoByClintId(String clientId) {
        return clientInfoService.findClientByClientId(clientId);
    }
}
