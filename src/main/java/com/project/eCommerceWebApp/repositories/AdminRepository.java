package com.project.eCommerceWebApp.repositories;

import com.project.eCommerceWebApp.entities.Admin;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, Long>{
    
}
