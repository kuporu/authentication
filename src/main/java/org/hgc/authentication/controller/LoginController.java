package org.hgc.authentication.controller;

import org.hgc.authentication.model.User;
import org.hgc.authentication.service.LoginServer;
import org.hgc.authentication.model.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    private LoginServer loginServer;

    @GetMapping("/test")
    public String test () {
        return "Hello world!";
    }

    @PostMapping("/login")
    public ResponseResult login (@RequestBody User user) {
        return loginServer.login(user);
    }

    @PostMapping("/register")
    public ResponseResult register (@RequestBody User user) {
        return loginServer.register(user);
    }

    @GetMapping("/logout")
    public ResponseResult logout () {
        return loginServer.logout();
    }
}
