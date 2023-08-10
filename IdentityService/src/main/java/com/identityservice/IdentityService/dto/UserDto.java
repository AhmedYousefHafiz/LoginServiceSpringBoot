package com.identityservice.IdentityService.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserDto {
    private long id;
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String email;
}
