package org.hgc.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Source {

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 最后一次登录时间
     */
    @NotNull(message = "用户最后登录时间不能为空")
    private Date lastLoginTime;

    /**
     * 城市天气查询编号
     */
    @NotNull(message = "城市天气查询编号不能为空")
    private String weatherId;
}
