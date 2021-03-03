package com.zrich.scribe.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.zrich.scribe.models.Role;
import com.zrich.scribe.models.User;
import com.zrich.scribe.repositories.RoleRepository;
import com.zrich.scribe.repositories.UserRepository;
import com.zrich.scribe.services.UserService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;
    private RoleRepository roleRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl( UserRepository userRepo, 
                            RoleRepository roleRepo, 
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User save(User usr) {
        log.info("Creating user with username: {} password: {}", usr.getUsername(), usr.getPassword());
        usr.setPassword(bCryptPasswordEncoder.encode(usr.getPassword()));
        usr.setActive(true);

        // TODO: move the admin role to it's own function
        Role role = roleRepo.findByRole("ADMIN");
        usr.setRoles(new HashSet<>(Arrays.asList(role)));
        
        return userRepo.save(usr);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
    
}
