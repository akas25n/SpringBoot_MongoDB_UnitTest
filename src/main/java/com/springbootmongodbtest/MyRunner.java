package com.springbootmongodbtest;

import com.springbootmongodbtest.Repository.CountryRepo;
import com.springbootmongodbtest.model.Country;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private CountryRepo countryRepo;

    @Override
    public void run(String... args) throws Exception {
        countryRepo.deleteAll();

        countryRepo.save(new Country("Bangladesh", 150000000));
        countryRepo.save(new Country("Germany", 100000000));


        countryRepo.findAll().forEach(country -> {
            logger.info("{}", country);
        });
    }
}
