package com.springbootmongodbtest.Repository;

import com.springbootmongodbtest.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryRepo extends MongoRepository<Country, String> {
}
