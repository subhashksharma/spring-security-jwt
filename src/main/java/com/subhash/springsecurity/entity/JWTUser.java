package com.subhash.springsecurity.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class JWTUser {

    @Id
    @GeneratedValue(
           strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String userName;
    private String password;
    private String email;

}
