package com.mock.platform.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rule")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
/**
 * @author wessonlan
 */
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer mockInterfaceId;
    private String ruleName;
    private String filterParams;
    private String filterBody;
    private String responseCode;
    private String responseBody;
    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
