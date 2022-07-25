package org.hgc.authentication.config;

import org.hgc.authentication.enums.ResultCode;
import org.hgc.authentication.model.error.APIException;
import org.hgc.authentication.model.vo.ResponseResult;
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

}
