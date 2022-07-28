package org.hgc.authentication.model.param;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class UserParam {
    /**
     * 账号
     * @mock hgc
     */
    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 4, message = "用户名长度必须为2-4个字符")
    private String name;

    /**
     * 密码
     * @mock 1234
     */
    @NotNull(message = "密码不能为空")
    @Size(min = 4, max = 6, message = "密码长度必须为4-6个字符")
    private String password;

    /**
     * 用户类型（暂时未涉及）
     * @mock 1
     */
    private int userType;

    /**
     * 删除标志（暂时未涉及）
     * @mock 0
     */
    private int delFlag;
}
