package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.UserRole;
import com.zjuici.authserver.dao.repository.UserRoleRepository;
import com.zjuici.authserver.service.UserRoleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserRoleServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:40
 * @Version 1.0
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    /**
     * userRoleRepository
     */
    @Resource
    private UserRoleRepository userRoleRepository;

    @Override
    public JpaRepository<UserRole, String> getJapRepository() {
        return userRoleRepository;
    }
}
