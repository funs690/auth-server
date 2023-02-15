package com.zjuici.authserver.config;

import cn.dev33.satoken.oauth2.logic.SaOAuth2Template;
import cn.dev33.satoken.oauth2.model.SaClientModel;
import com.zjuici.authserver.biz.UpmBizService;
import com.zjuici.authserver.dao.po.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * sa oauth2 template
 */
@Component
public class SaOauth2TemplateConfig extends SaOAuth2Template {


    /**
     * upmBizService
     */
    @Autowired
    private UpmBizService upmBizService;


    @Override
    public SaClientModel getClientModel(String clientId) {
        ClientInfo clientInfo = upmBizService.findClientInfoByClintId(clientId);
        if (clientInfo == null){
            return null;
        }
        return new SaClientModel()
                .setClientId(clientInfo.getClientId())
                .setClientSecret(clientInfo.getClientSecret())
                .setAllowUrl(clientInfo.getRedirectUrl())
                .setContractScope(clientInfo.getScope())
                .setIsAutoMode(true);
    }

    @Override
    public String getOpenid(String clientId, Object loginId) {
        // 此为模拟数据，真实环境需要从数据库查询
        return "gr_SwoIN0MC1ewxHX_vfCW3BothWDZMMtx__";
    }
}
