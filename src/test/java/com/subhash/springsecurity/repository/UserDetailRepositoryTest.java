package com.subhash.springsecurity.repository;

import com.subhash.springsecurity.entity.JWTUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDetailRepositoryTest {

    @Autowired
    private UserDetailRepository userDetailRepository;


    @Test
    void saveUser() {

        JWTUser user = JWTUser.builder()
                .userName("subhash")
                .email("subhash.bvb@gmail.com")
                .password("subhash")
                .build();
        userDetailRepository.save(user);
    }

}