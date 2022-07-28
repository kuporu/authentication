package org.hgc.authentication.model.param;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SourceParam {
    /**
     * 城市天气查询编号
     * @mock CN101040700
     */
    @NotNull(message = "城市天气查询编号不能为空")
    private String weatherId;
}
