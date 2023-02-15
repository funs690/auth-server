package com.zjuici.authserver.config;

import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author fuzeqiang
 * @version 1.0
 * @date 2021/3/18 17:48
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    // 全局异常拦截
    @ExceptionHandler
    public SaResult handlerException(Exception e) {
        e.printStackTrace();
        return SaResult.error(e.getMessage());
    }

}
