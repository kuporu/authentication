package org.hgc.authentication.controller;

import org.hgc.authentication.model.User;
import org.hgc.authentication.model.param.UserParam;
import org.hgc.authentication.service.LoginServer;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private LoginServer loginServer;

    /**
     * 登录
     * @param userParam
     * @return
     */
    @PostMapping("/login")
    public ResponseResult<Map<String, String>> login (@RequestBody UserParam userParam) {
        return loginServer.login(userParam);
    }

    /**
     * 注册
     * @param userParam
     * @return
     */
    @PostMapping("/register")
    public ResponseResult<String> register (@RequestBody @Valid UserParam userParam) {
        return loginServer.register(userParam);
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("/logout")
    public ResponseResult<String> logout () {
        return loginServer.logout();
    }
}
