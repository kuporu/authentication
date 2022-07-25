package org.hgc.authentication.enums;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS(1001, "操作成功"),

    FAILED(1002, "响应失败"),

    VALIDATE_FAILED(1003, "参数校验失败"),

    ERROR(1004, "未知错误"),

    LOGIN_ERROR(1005, "登录失败"),

    USERNAME_EXISTS(1006, "用户账号已存在"),

    FIRST_LOGIN(1007, "用户账号首次登录，没有缓存数据");

    private int code;

    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
