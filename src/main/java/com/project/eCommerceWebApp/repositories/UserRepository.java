package com.project.eCommerceWebApp.repositories;

import com.project.eCommerceWebApp.entities.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * MongoRepository<Entity, EntityIDType>
 */
public interface UserRepository extends MongoRepository<User, Long>{
    //Fuchka
}
