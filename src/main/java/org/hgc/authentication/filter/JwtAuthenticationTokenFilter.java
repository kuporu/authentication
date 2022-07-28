package org.hgc.authentication.filter;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import org.hgc.authentication.enums.ResultCode;
import org.hgc.authentication.model.error.APIException;
import org.hgc.authentication.model.vo.ResponseResult;
import org.hgc.authentication.security.LoginUserDetails;
import org.hgc.authentication.utils.JwtUtil;
import org.hgc.authentication.utils.RedisCache;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 1. 从请求头中获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
//            response.setContentType("application/json;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.write(JSON.toJSONString(new ResponseResult<String>(ResultCode.LOGIN_ERROR, "未携带登录凭证")));
//            out.flush();
//            out.close();
//            return;
        }

        // 2. 解析token，获取用户id，再从redis中获取用户完整信息
        String userId = null;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            // 登录错误统一由Spring Security ExceptionTranslationFilter 捕获并处理
            filterChain.doFilter(request, response);
            return;
//            response.setContentType("application/json;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.write(JSON.toJSONString(new ResponseResult<String>(ResultCode.LOGIN_ERROR, "登录凭证错误")));
//            out.flush();
//            out.close();
//            return;
        }
        String redisKey = "login:" + userId;
        LoginUserDetails loginUser = redisCache.getCacheObject(redisKey);
        if (Objects.isNull(loginUser)) {
            filterChain.doFilter(request, response);
            return;
//            response.setContentType("application/json;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.write(JSON.toJSONString(new ResponseResult<String>(ResultCode.LOGIN_ERROR, "缓存失效")));
//            out.flush();
//            out.close();
//            return;
        }

        // 3. 将Authentication存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
