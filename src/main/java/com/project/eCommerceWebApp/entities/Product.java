package com.project.eCommerceWebApp.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    /**
     * The following two lines are added to make the id
     * auto-generated (auto-incremented).
     */
    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";
    
    /**
     * ID should be preferably of type "Long" according
     * to the SequenceGeneratorService configuration.
     */
    @Id
    private Long id;

    private String name;

    private Double price;

    private String category;

    private Double discounts;

    private LocalDate date_added;

    private Long qty;

    private String image_url;

    private String description;

    private String brand_name;

    private int rating;

    //commets
    
}
