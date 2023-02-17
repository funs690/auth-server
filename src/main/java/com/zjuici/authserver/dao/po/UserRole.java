package com.zjuici.authserver.dao.po;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserRole
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:30
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 718295822179610066L;

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
     * 角色id
     */
    private String roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
