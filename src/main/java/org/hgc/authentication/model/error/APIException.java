package org.hgc.authentication.model.error;

import lombok.Getter;
import org.hgc.authentication.enums.ResultCode;

/**
 * 自定义异常类
 */
@Getter //只要getter方法，无需setter
public class APIException extends RuntimeException {

    /**
     * 异常状态码，暂时没有用上
     */
//    private int code;

    /**
     * 异常信息
     */
    private String msg;

    public APIException(String msg) {
        super(msg);
//        this.code = resultCode.getCode();
        this.msg = msg;
    }
}