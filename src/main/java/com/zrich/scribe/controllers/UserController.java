package com.zrich.scribe.controllers;

import java.util.List;

import com.zrich.scribe.exceptions.EntityNotFoundException;
import com.zrich.scribe.models.User;
import com.zrich.scribe.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@SuppressWarnings("all")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found."));
    }

    @PostMapping("/")
    public User addUser(@RequestBody User usr) {
        return userService.save(usr);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User newUsr) {
        User usr = userService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found."));

        usr.setName(newUsr.getName());
        usr.setEmail(newUsr.getEmail());

        return userService.save(usr);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        User usr = userService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found."));

        userService.deleteById(usr.getId());
        return "User with id " + id + " is deleted";
    }

    
}
