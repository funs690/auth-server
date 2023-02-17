package com.zjuici.authserver.dao.po;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UpmResource
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/7 17:29
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_upm_resource")
public class UpmResource implements Serializable {


    private static final long serialVersionUID = 5085825532657821908L;
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
     * 资源名称
     */
    private String resourceName;

    /**
     * 资源类型
     */
    private String resourceType;

    /**
     * 是否删除,0：未删除,1：已删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
