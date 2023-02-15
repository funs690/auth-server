package com.zjuici.authserver.dao.po;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UpmAuth
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:28
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_upm_auth")
public class UpmAuth implements Serializable {


    private static final long serialVersionUID = -1434849456952071036L;
    /**
     * 唯一键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 资源id
     */
    private String resourceId;

    /**
     * 资源类型
     */
    private Integer resourceType;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private String roleId;

    /**
     * 操作用户id
     */
    private String opUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
