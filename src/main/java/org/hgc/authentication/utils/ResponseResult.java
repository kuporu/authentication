package org.hgc.authentication.utils;

public class ResponseResult<T> {

    private final int code;

    private final String msg;

    private T data;

    public ResponseResult(String msg) {
        this.code = 200;
        this.msg = msg;
    }

    /*
    如果没有get方法客户端请求状态码为406
     */
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ResponseResult<T> success (T data) {
        return new ResponseResult<T>(data);
    }

    public static <T> ResponseResult<T> success (String msg) {
        return new ResponseResult<T>(msg);
    }

    public static <T> ResponseResult<T> error (int code, String msg) {
        return new ResponseResult<T>(code, msg);
    }
}
