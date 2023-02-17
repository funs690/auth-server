package com.zjuici.authserver.service.impl;

import com.zjuici.authserver.dao.po.ClientInfo;
import com.zjuici.authserver.dao.repository.ClientInfoRepository;
import com.zjuici.authserver.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


/**
 * @ClassName ClientInfoImpl
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/8 11:20
 * @Version 1.0
 */
@Service
public class ClientInfoServiceImpl implements ClientInfoService {

    /**
     * clientInfoRepository
     */
    @Autowired
    private ClientInfoRepository clientInfoRepository;


    @Override
    public JpaRepository<ClientInfo, String> getJapRepository() {
        return clientInfoRepository;
    }


    @Override
    public ClientInfo findClientByClientId(String clientId) {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId(clientId);
        return clientInfoRepository.findOne(Example.of(clientInfo)).get();
    }
}
