package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.UpmAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UpmAuthRepository
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:34
 * @Version 1.0
 */
@Repository
public interface UpmAuthRepository extends JpaRepository<UpmAuth, String> {
}
