package org.hgc.authentication.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mysql.cj.log.Log;
import org.hgc.authentication.mapper.UserMapper;
import org.hgc.authentication.pojo.LoginUser;
import org.hgc.authentication.pojo.User;
import org.hgc.authentication.service.LoginServer;
import org.hgc.authentication.utils.JwtUtil;
import org.hgc.authentication.utils.RedisCache;
import org.hgc.authentication.utils.ResponseResult;
import org.hgc.authentication.utils.UserContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServer {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserMapper userMapper;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {

        // 1. 用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
//            throw new RuntimeException("用户名或密码错误");
            return ResponseResult.error(201, "用户名或密码错误");
        }

        // 2. 认证成功生成JWT
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Long userId = loginUser.getUser().getId();
        String jwt = JwtUtil.createJWT(userId.toString());
        Map<String, String> map = new HashMap<>();
        map.put("token", jwt);

        // 3. 保存用户详细信息到Redis中
        redisCache.setCacheObject("login:" + userId, loginUser);
        return ResponseResult.success(map);
    }

    @Override
    public ResponseResult logout() {

        // 1. 从 SecurityContextHolder中获取用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        long userId = loginUser.getUser().getId();

        // 2. 从 Redis 中删除用户信息
        String redisKey = "login:" + userId;
        redisCache.deleteObject(redisKey);

        return ResponseResult.success("退出成功");
    }

    @Override
    public ResponseResult register(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, user.getName());
        User selectOne = userMapper.selectOne(lambdaQueryWrapper);
        if (!Objects.isNull(selectOne)) {
            return ResponseResult.error(202, "用户已存在");
        } else {

            String password = user.getPassword();
            String encode = passwordEncoder.encode(password); // 往数据库中添加密码的时候就需要加密
            user.setPassword(encode);
            userMapper.insert(user);
            return ResponseResult.success("添加用户成功");
        }
    }
}
