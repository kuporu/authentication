package org.hgc.authentication.service;

import org.hgc.authentication.model.User;
import org.hgc.authentication.model.param.UserParam;
import org.hgc.authentication.model.vo.ResponseResult;

import java.util.Map;

public interface LoginServer {
    ResponseResult<Map<String, String>> login(UserParam userParam);

    ResponseResult<String> logout();

    ResponseResult<String> register(UserParam user);
}
