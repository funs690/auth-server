package com.zjuici.authserver.dao.po;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:30
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 4187720055732926835L;

    /**
     * 唯一键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 地址信息
     */
    private String address;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
