package com.subhash.springsecurity.controller;

import com.subhash.springsecurity.entity.JWTUser;
import com.subhash.springsecurity.model.AuthRequest;
import com.subhash.springsecurity.model.UserModel;
import com.subhash.springsecurity.service.UserService;
import com.subhash.springsecurity.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserValidationController {


    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/welcome")
    public String userValidationResult() {
        return "user";
    }

    @PostMapping("/authenticate")
    public String authenticateToken( @RequestBody AuthRequest authRequest) throws Exception {
        try {
            System.out.println("test");
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(authRequest.getUserName()
            , authRequest.getPassword()));

        }catch (Exception  e) {
            throw new BadCredentialsException(" no valid user");
        }

      return  jwtUtil.generateToken(authRequest.getUserName());

    }



    @PostMapping("/saveuser")
    public ResponseEntity saveUser(@RequestBody UserModel userModel) {
        JWTUser user = userService.saveUser(userModel);
        return ResponseEntity.ok(user);
    }
}
