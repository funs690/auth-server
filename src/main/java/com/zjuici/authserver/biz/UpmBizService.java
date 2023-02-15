package com.zjuici.authserver.biz;

import cn.dev33.satoken.util.SaResult;
import com.zjuici.authserver.dao.po.ClientInfo;

/**
 * @ClassName UpmBizService
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 18:59
 * @Version 1.0
 */
public interface UpmBizService {

    /**
     * @desc: 用户登录
     * @author: fuzeqiang
     * @date: 2023/2/8 11:30
     * @param name 用户名
     * @param pwd 密码
     * @return cn.dev33.satoken.util.SaResult
     **/
    SaResult login(String name, String pwd);

    /**
     * @desc: 获取客户端登录信息
     * @author: fuzeqiang
     * @date: 2023/2/8 11:31
     * @param clientId 客户端id
     * @return com.zjuici.authserver.dao.po.ClientInfo
     **/
    ClientInfo findClientInfoByClintId(String clientId);
}
