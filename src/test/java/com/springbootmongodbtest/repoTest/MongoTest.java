package com.springbootmongodbtest.repoTest;

import com.springbootmongodbtest.Repository.CountryRepo;
import com.springbootmongodbtest.model.Country;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTest {

    @Autowired
    private CountryRepo countryRepo;

    private static final int NUMBER_OF_COUNTRY = 3;

    List<Country> countries = new ArrayList<>();

    @Before
    public void init(){
        countryRepo.deleteAll();
        countryRepo.save(new Country("Ban", 150000));
        countryRepo.save(new Country("DE", 100000));
        countryRepo.save(new Country("SW", 10000));
    }

    @Test
    public void countCountries(){
        Assertions.assertEquals(NUMBER_OF_COUNTRY, countryRepo.findAll().size());
    }

    @Test
    public void setsIdOnSave(){
        Country country = countryRepo.save(new Country("Ban", 150000));
        Assertions.assertNotNull(country.getId());
    }

    @Test
    public void findOneCountry(){

        Country country = new Country();
        country.setName("ban");
        country.setPopulation(15000);

        countries.add(country);

        for (Country c: countries){
            Assertions.assertEquals(c.getName(), "ban");
        }
    }
}
