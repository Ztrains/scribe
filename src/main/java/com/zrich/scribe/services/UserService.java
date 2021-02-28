package com.zrich.scribe.services;

import java.util.List;
import java.util.Optional;

import com.zrich.scribe.models.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    Optional<User> findById(int id);
    User findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    
    UserDetails loadUserByUsername(String username);

    User save(User usr);

    void deleteById(int id);
    
}
