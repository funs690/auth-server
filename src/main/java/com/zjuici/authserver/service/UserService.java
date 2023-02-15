package com.zjuici.authserver.service;

import com.zjuici.authserver.dao.po.User;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:38
 * @Version 1.0
 */
public interface UserService extends BasicService<User, String> {

    /**
     * @desc: 根据用户名获取用户信息
     * @author: fuzeqiang
     * @date: 2023/2/8 11:26
     * @param name 用户名
     * @return com.zjuici.authserver.dao.po.User
     **/
    User getUserByUserName(String name);
}
