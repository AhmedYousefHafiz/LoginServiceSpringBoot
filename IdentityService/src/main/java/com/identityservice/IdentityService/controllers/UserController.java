package com.identityservice.IdentityService.controllers;


import com.identityservice.IdentityService.dto.UserDto;
import com.identityservice.IdentityService.entity.User;
import com.identityservice.IdentityService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<String> testAPI() {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/api/register")
    public ResponseEntity<User> registerUser(@RequestBody UserDto userDTO) {
        try {
            User user = userService.registerUser(userDTO);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
