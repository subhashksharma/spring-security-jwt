package com.subhash.springsecurity.service;

import com.subhash.springsecurity.entity.JWTUser;
import com.subhash.springsecurity.model.UserModel;

public interface UserService {

    JWTUser findUserByUserName(String userName) throws Exception;

    JWTUser saveUser(UserModel user);
}

