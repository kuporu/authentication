package org.hgc.authentication.controller;

import org.hgc.authentication.pojo.Source;
import org.hgc.authentication.pojo.User;
import org.hgc.authentication.service.LoginServer;
import org.hgc.authentication.service.SourceService;
import org.hgc.authentication.utils.ResponseResult;
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
