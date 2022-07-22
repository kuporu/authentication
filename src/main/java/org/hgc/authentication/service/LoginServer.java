package org.hgc.authentication.service;

import org.hgc.authentication.pojo.User;
import org.hgc.authentication.utils.ResponseResult;

public interface LoginServer {
    ResponseResult login(User user);

    ResponseResult logout();

    ResponseResult register(User user);
}
