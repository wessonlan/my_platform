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
    @Id //声明一个字段“id”为数据库表的主键
    @GeneratedValue(strategy = GenerationType.AUTO) //标注主键的生成策略，通过strategy 属性指定
    @Column(name = "id") //被标注字段在数据库表中所对应字段的名称
    private int id; //用户id
    private String username; //用户名称
    private String password; //密码
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime; //创建时间
}
