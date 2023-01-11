package com.user.service.userservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.userservice.Model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
    
}
