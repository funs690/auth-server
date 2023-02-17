package com.zjuici.authserver.dao.po;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;

/**
 * @ClassName ClientInfo
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/8 11:16
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_client_info")
public class ClientInfo {

    /**
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 客户端密钥
     */
    private String clientSecret;

    /**
     * 重定向url
     */
    private String redirectUrl;

    /**
     * scope
     */
    private String scope;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
