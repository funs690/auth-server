package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRoleRepository
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:37
 * @Version 1.0
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
