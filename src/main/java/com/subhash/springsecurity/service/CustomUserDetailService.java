package com.subhash.springsecurity.service;

import com.subhash.springsecurity.entity.JWTUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        JWTUser jwtUser = null;

        try {
             jwtUser = userService.findUserByUserName(username);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(jwtUser.getUserName(),
        jwtUser.getPassword(),
                true, true, true, true, getAuthorities());
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<GrantedAuthority> list = new ArrayList<>();

        return list;
    }
}
