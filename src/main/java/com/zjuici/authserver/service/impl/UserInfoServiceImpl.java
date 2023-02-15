package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.UserInfo;
import com.zjuici.authserver.dao.repository.UserInfoRepository;
import com.zjuici.authserver.service.UserInfoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:40
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    /**
     * userInfoRepository
     */
    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public JpaRepository<UserInfo, String> getJapRepository() {
        return userInfoRepository;
    }
}
