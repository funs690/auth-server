package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.Role;
import com.zjuici.authserver.dao.repository.RoleRepository;
import com.zjuici.authserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:39
 * @Version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     * roleRepository
     */
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public JpaRepository<Role, String> getJapRepository() {
        return roleRepository;
    }
}
