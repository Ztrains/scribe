package com.zrich.scribe.impl;

import java.util.List;
import java.util.Optional;

import com.zrich.scribe.models.User;
import com.zrich.scribe.repositories.UserRepository;
import com.zrich.scribe.services.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User save(User usr) {
        return userRepo.save(usr);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
    
}
