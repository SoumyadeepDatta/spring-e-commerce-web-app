package com.project.eCommerceWebApp.controllers;

import java.util.Optional;

import com.project.eCommerceWebApp.entities.Admin;
import com.project.eCommerceWebApp.repositories.AdminRepository;
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
@RequestMapping("/admin")

public class AdminController {

    @Autowired 
    private AdminRepository adminRepository;


    /**
     * Add the following two lines in your controller
     * if you wish to use the SequenceGeneratorService service.
     */
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/add")
    public ResponseEntity<?> addadmin(@RequestBody Admin admin) {

        /**
         * This line is added to generate the id of the 
         * newly received entity and increment it automatically.
         */
        admin.setId(sequenceGeneratorService.getSequenceNumber(Admin.SEQUENCE_NAME));

        return ResponseEntity.ok(this.adminRepository.save(admin));

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> findAlladmin() {

        return ResponseEntity.ok(this.adminRepository.findAll());
        
    }

    @GetMapping("/getById/{aid}")
    public ResponseEntity<?> getadminById(@PathVariable("aid") Long aid) {

        if(!adminRepository.existsById(aid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        else {
            return ResponseEntity.ok(this.adminRepository.findById(aid));
        }

    }

    @DeleteMapping("/delete/{aid}")
    public ResponseEntity<?> deleteadminById(@PathVariable("aid") Long aid) {

        // Optional<admin> admin = adminRepository.findById(aid);

        if(!adminRepository.existsById(aid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        else {
            this.adminRepository.deleteById(aid);
            return new ResponseEntity<>(aid, HttpStatus.OK);
        }

    }

    @PutMapping("/update/{aid}")
    public ResponseEntity<?> updateadmin(@PathVariable Long aid, @RequestBody Admin admin) {

        if(!adminRepository.existsById(aid)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            admin.setId(aid);
            return ResponseEntity.ok(this.adminRepository.save(admin));

        }
    }
    
}
