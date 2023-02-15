package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RoleRepository
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:31
 * @Version 1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
