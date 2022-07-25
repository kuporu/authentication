package org.hgc.authentication.config;

import org.hgc.authentication.enums.ResultCode;
import org.hgc.authentication.model.error.APIException;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class ExceptionControllerAdvance {

    @ExceptionHandler(APIException.class)
    public ResponseResult APIExceptionHandler (APIException e) {
        return new ResponseResult(ResultCode.FAILED, e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult MethodArgumentNotValidExceptionHandler (MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResponseResult(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
}
