package com.project.eCommerceWebApp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class User {

    /**
     * The following two lines are added to make the id
     * auto-generated (auto-incremented).
     */
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";
    
    /**
     * ID should be preferably of type "Long" according
     * to the SequenceGeneratorService configuration.
     */
    @Id
    private Long id;

    private String name;
    
}
