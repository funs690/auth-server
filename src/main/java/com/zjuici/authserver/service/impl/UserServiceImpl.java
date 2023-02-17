package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.User;
import com.zjuici.authserver.dao.repository.UserRepository;
import com.zjuici.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:41
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * userRepository
     */
    @Autowired
    private UserRepository userRepository;

    @Override
    public JpaRepository<User, String> getJapRepository() {
        return userRepository;
    }

    /**
     * @desc: 根据用户名获取用户信息
     * @author: fuzeqiang
     * @date: 2023/2/8 11:26
     * @param name 用户名
     * @return com.zjuici.authserver.dao.po.User
     **/
    @Override
    public User getUserByUserName(String name) {
        User user = new User();
        user.setUsername(name);
        return userRepository.findOne(Example.of(user)).get();
    }
}
