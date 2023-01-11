package com.user.service.userservice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.userservice.Model.UserModel;
import com.user.service.userservice.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<UserModel> getAll() {
        return repository.findAll();
    }

    public Optional<UserModel> getUserById(Integer id) {
        return repository.findById(id);
    }

    public UserModel saveUser(UserModel usuario) {
        return repository.save(usuario);
    }

    public boolean deleteUserById(Integer id) {
        try{
            repository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}