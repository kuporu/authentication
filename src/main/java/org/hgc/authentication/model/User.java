package org.hgc.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 4, message = "用户名长度必须为2-4个字符")
    private String name;

    @NotNull(message = "密码不能为空")
    @Size(min = 4, max = 6, message = "密码长度必须为4-6个字符")
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
