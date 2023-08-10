package com.identityservice.IdentityService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.identityservice.IdentityService.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
