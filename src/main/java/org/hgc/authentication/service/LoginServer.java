package org.hgc.authentication.service;

import org.hgc.authentication.model.User;
import org.hgc.authentication.model.vo.ResponseResult;

public interface LoginServer {
    ResponseResult login(User user);

    ResponseResult logout();

    ResponseResult register(User user);
}
