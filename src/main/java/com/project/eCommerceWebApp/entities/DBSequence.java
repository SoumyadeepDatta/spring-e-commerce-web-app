package com.project.eCommerceWebApp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a MongoDB configuration entity.
 * Do not change any code below.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "db_sequence")
public class DBSequence {

    @Id
    private String id;

    /**
     * The type of the sequence variable is 
     * reflected on the type of entity id 
     * which is using this service.
     */
    private long sequence;
    
}