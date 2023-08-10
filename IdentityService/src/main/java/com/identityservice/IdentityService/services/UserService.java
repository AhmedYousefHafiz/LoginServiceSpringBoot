package com.identityservice.IdentityService.services;

import com.identityservice.IdentityService.dto.UserDto;
import com.identityservice.IdentityService.entity.User;
import com.identityservice.IdentityService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserDto userDto) {
        User user =new User();
        user.setId(11111);
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getPassword());
        this.userRepository.save(user);
        return user;
    }


}
