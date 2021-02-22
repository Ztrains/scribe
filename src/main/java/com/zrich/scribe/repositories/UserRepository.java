package com.zrich.scribe.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.zrich.scribe.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Query method
    Optional<User> findByEmail(String email);
    
}
