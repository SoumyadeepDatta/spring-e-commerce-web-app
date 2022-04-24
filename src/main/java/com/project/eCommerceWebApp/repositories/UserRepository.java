package com.project.eCommerceWebApp.repositories;

import com.project.eCommerceWebApp.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long>{
    
}
