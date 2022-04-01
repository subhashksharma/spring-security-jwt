package com.subhash.springsecurity.repository;

import com.subhash.springsecurity.entity.JWTUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<JWTUser, Long> {
    JWTUser findJWTUsersByUserName(String userName);
}
