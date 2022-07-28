package org.hgc.authentication.model.vo;

import lombok.Getter;
import org.hgc.authentication.enums.ResultCode;

@Getter
public class ResponseResult<T> {
    /**
     * 状态码
     * @mock 1001
     */
    private final int code;
    /**
     * 响应信息
     * @mock 操作成功
     */
    private final String msg;
    /**
     * 响应的具体消息
     */
    private T data;

    /**
     * 其他情况下的响应
     * @param resultCode 枚举类型
     * @param data 返回数据
     */
    public ResponseResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    /**
     * 请求响应成功，返回数据
     * @param data 返回数据
     */
    public ResponseResult(T data) {
        this(ResultCode.SUCCESS, data);
    }
}
