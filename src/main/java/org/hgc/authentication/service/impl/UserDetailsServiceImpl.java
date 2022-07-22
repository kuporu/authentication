package org.hgc.authentication.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.hgc.authentication.mapper.UserMapper;
import org.hgc.authentication.pojo.LoginUser;
import org.hgc.authentication.pojo.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. 根据用户名查询对应的用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, username);
        User user = userMapper.selectOne(queryWrapper);

        // 2. 查询权限信息（暂时不需要）

        // 3. 把对应的用户信息封装成 UserDetails 对象并返回
        if (user != null) {
            return new LoginUser(user);
        }

        throw new UsernameNotFoundException("没有找到该用户");
    }
}
