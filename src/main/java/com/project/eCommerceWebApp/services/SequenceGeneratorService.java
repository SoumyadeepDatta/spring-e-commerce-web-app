package com.project.eCommerceWebApp.services;

import com.project.eCommerceWebApp.entities.DBSequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

/**
 * This is a spring service used 
 * for auto generation of Entity ID.
 * Do not change any codes below.
 */
@Service
public class SequenceGeneratorService {
    
    @Autowired
    private MongoOperations mongoOperations;

    /**
     * The return type of this method should be equal to that of the 
     * type of Entity ID which is using the following service.
     * @param sequenceName
     * @return
     */
    public long getSequenceNumber(String sequenceName) {
        
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("sequence", 1);

        DBSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), DBSequence.class);

        return !Objects.isNull(counter) ? counter.getSequence() : 1;

    }
}
