package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserInfoRepositpry
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:35
 * @Version 1.0
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
}
