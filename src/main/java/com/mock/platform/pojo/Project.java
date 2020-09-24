package com.mock.platform.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity //表示这是一个实体类
@Table(name = "project") //表示对应的表名是 project
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
/**
 * @author wessonlan
 */
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer uid;
    private String projectName;
    private String description;
    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
