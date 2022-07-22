package org.hgc.authentication.interceptor;

import io.jsonwebtoken.Claims;
import org.hgc.authentication.utils.JwtUtil;
import org.hgc.authentication.utils.UserContext;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("/user/login".equals(request.getRequestURI())) {
            return true;
        }
        if ("/user/register".equals(request.getRequestURI())) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            return false;
        }
        Claims claims = JwtUtil.parseJWT(token);
        String userId = claims.getSubject();
        UserContext.add(Long.parseLong(userId));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContext.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
