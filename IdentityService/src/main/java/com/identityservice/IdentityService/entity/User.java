package com.identityservice.IdentityService.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "userInfo")
@Getter
@Setter
public class User {

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
}
