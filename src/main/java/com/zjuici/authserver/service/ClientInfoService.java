package com.zjuici.authserver.service;

import com.zjuici.authserver.dao.po.ClientInfo;

/**
 * @ClassName ClientInfoService
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/8 11:20
 * @Version 1.0
 */
public interface ClientInfoService extends BasicService<ClientInfo, String>{


    /**
     * @desc:  根据client id 获取client 信息
     * @author: fuzeqiang
     * @date: 2023/2/8 11:23
     * @param clientId 客户端id
     * @return com.zjuici.authserver.dao.po.ClientInfo
     **/
    ClientInfo findClientByClientId(String clientId);

}
