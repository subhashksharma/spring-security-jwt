package com.subhash.springsecurity.service;

import com.subhash.springsecurity.entity.JWTUser;
import com.subhash.springsecurity.model.UserModel;
import com.subhash.springsecurity.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public JWTUser findUserByUserName(String userName) throws  Exception{
        JWTUser user = userDetailRepository.findJWTUsersByUserName(userName);
        if(user == null) {
            throw new BadCredentialsException("No User found");
        }
        return user;
    }

    @Override
    public JWTUser saveUser(UserModel user) {

        JWTUser userToSave  = JWTUser.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();

        return userDetailRepository.save(userToSave);
    }
}
