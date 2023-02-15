package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.UpmAuth;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UpmAuthRepository
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:34
 * @Version 1.0
 */
public interface UpmAuthRepository extends JpaRepository<UpmAuth, String> {
}
