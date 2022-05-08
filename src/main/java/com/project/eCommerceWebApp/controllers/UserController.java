package com.project.eCommerceWebApp.controllers;

import java.util.Optional;

import com.project.eCommerceWebApp.entities.User;
import com.project.eCommerceWebApp.repositories.UserRepository;
import com.project.eCommerceWebApp.services.SequenceGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    /**
     * Add the following two lines in your controller
     * if you wish to use the SequenceGeneratorService service.
     */
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user) {

        /**
         * This line is added to generate the id of the 
         * newly received entity and increment it automatically.
         */
        user.setId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));

        return ResponseEntity.ok(this.userRepository.save(user));

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAllUser() {

        return ResponseEntity.ok(this.userRepository.findAll());
        
    }

    @GetMapping("/getById/{uid}")
    public ResponseEntity<?> getUserById(@PathVariable("uid") Long uid) {

        if(!userRepository.existsById(uid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        else {
            return ResponseEntity.ok(this.userRepository.findById(uid));
        }

    }

    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<?> deleteUserById(@PathVariable("uid") Long uid) {

        // Optional<User> user = userRepository.findById(uid);

        if(!userRepository.existsById(uid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        else {
            this.userRepository.deleteById(uid);
            return new ResponseEntity<>(uid, HttpStatus.OK);
        }

    }

    @PutMapping("/update/{uid}")
    public ResponseEntity<?> updateUser(@PathVariable Long uid, @RequestBody User user) {

        if(!userRepository.existsById(uid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            user.setId(uid);
            return ResponseEntity.ok(this.userRepository.save(user));

        }
    }
}
