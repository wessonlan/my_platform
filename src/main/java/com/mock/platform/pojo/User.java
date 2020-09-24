package com.mock.platform.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data

public class User {
    //声明一个字段“id”为数据库表的主键
    @Id
    //标注主键的生成策略，通过strategy 属性指定
    @GeneratedValue(strategy = GenerationType.AUTO)
    //被标注字段在数据库表中所对应字段的名称
    @Column(name = "id")
    /**
     *id
     */
    private int id;
    /**
     * 用户名称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
