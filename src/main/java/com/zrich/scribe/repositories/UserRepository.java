package com.zrich.scribe.repositories;

import com.zrich.scribe.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Query method
    User findByUsername(String username);

}
