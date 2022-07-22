package org.hgc.authentication.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String name;

    private String password;

    private int userType;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Date deleteTime;

    private String deleteBy;

    private int delFlag;
}
