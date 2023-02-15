package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.UpmResource;
import com.zjuici.authserver.dao.repository.UpmResourceRepository;
import com.zjuici.authserver.service.UpmResourceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UpmResourceServiceImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:40
 * @Version 1.0
 */
@Service
public class UpmResourceServiceImpl implements UpmResourceService {


    /**
     * upmResourceRepository
     */
    @Resource
    private UpmResourceRepository upmResourceRepository;

    @Override
    public JpaRepository<UpmResource, String> getJapRepository() {
        return upmResourceRepository;
    }
}
