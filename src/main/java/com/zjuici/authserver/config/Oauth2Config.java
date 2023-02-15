package com.zjuici.authserver.config;

import cn.dev33.satoken.oauth2.config.SaOAuth2Config;
import com.zjuici.authserver.biz.UpmBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Component
public class Oauth2Config {


    /**
     * upm biz service
     */
    @Autowired
    private UpmBizService upmBizService;

    // Sa-OAuth2 定制化配置
    @Autowired
    public void setSaOAuth2Config(SaOAuth2Config cfg) {
        cfg.
                // 配置：未登录时返回的View
                setNotLoginView(() -> new ModelAndView("/login.html")).
                // 配置：登录处理函数
                setDoLoginHandle((name, pwd) -> upmBizService.login(name, pwd)).
                // 配置：确认授权时返回的View
                setConfirmView((clientId, scope) -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("clientId", clientId);
                    map.put("scope", scope);
                    return new ModelAndView("/confirm.html", map);
                })
        ;
    }
}
