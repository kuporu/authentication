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

    /**
     * id
     */
    private Long id;

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
     */
    private int userType;

    /**
     * 创建时间（暂时未涉及）
     */
    private Date createTime;

    /**
     * 创建人（暂时未涉及）
     */
    private String createBy;

    /**
     * 修改时间（暂时未涉及）
     */
    private Date updateTime;

    /**
     * 修改人（暂时未涉及）
     */
    private String updateBy;

    /**
     * 删除时间（暂时未涉及）
     */
    private Date deleteTime;

    /**
     * 删除人（暂时未涉及）
     */
    private String deleteBy;

    /**
     * 删除标志（暂时未涉及）
     */
    private int delFlag;
}
