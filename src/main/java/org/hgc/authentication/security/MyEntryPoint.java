package org.hgc.authentication.security;

import com.alibaba.fastjson.JSON;
import org.hgc.authentication.enums.ResultCode;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();


        if ("/user/login".equals(request.getRequestURI())) {
            // 处理登录接口登录认证错误
            out.write(JSON.toJSONString(new ResponseResult(ResultCode.LOGIN_ERROR, "用户名或密码错误")));

        } else {
            // 处理其他接口登录认证错误
            out.write(JSON.toJSONString(new ResponseResult(ResultCode.LOGIN_ERROR, "用户未登录")));
        }
        out.flush();
        out.close();
    }
}