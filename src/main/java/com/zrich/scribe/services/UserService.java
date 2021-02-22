package com.zrich.scribe.services;

import java.util.List;
import java.util.Optional;

import com.zrich.scribe.models.User;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);

    User save(User usr);

    void deleteById(int id);
    
}
