package com.mock.platform.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "interface")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
/**
 * @author wessonlan
 */
public class Interface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer pid;
    private String interfaceName;
    private String requestMethod;
    private String requestPath;
    private String interfaceDescribe;
    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
