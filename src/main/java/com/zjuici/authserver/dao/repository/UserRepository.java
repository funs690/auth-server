package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRepository
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:35
 * @Version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
