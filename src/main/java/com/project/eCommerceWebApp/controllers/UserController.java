package com.project.eCommerceWebApp.controllers;

import com.project.eCommerceWebApp.entities.User;
import com.project.eCommerceWebApp.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user) {

        return ResponseEntity.ok(this.userRepository.save(user));

    }

    @GetMapping("/")
    public ResponseEntity<?> findAllUser() {

        return ResponseEntity.ok(this.userRepository.findAll());
        
    }
}
