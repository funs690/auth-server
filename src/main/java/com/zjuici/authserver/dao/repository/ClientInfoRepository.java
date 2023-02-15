package com.zjuici.authserver.dao.repository;

import com.zjuici.authserver.dao.po.ClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName ClientInfoRepository
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/8 11:20
 * @Version 1.0
 */
@Repository
public interface ClientInfoRepository extends JpaRepository<ClientInfo, String> {
}
