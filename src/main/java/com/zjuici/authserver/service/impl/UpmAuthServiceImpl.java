package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.UpmAuth;
import com.zjuici.authserver.dao.repository.UpmAuthRepository;
import com.zjuici.authserver.service.UpmAuthService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UpmAuthServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:39
 * @Version 1.0
 */
@Service
public class UpmAuthServiceImpl implements UpmAuthService {

    @Resource
    private UpmAuthRepository upmAuthRepository;

    @Override
    public JpaRepository<UpmAuth, String> getJapRepository() {
        return upmAuthRepository;
    }
}
