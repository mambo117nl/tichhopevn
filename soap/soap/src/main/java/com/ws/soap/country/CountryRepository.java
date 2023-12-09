package com.ws.soap.country;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.baeldung.springsoap.gen.Country;
import com.baeldung.springsoap.gen.Currency;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();
	

    @PostConstruct
    public void initData() {
        // initialize countries map
    	Country peter = new Country();
        peter.setCapital("VietNam");
        peter.setCurrency(Currency.EUR);
        peter.setName("VN");
        peter.setPopulation(20000);

   

        countries.put(peter.getName(), peter);
      
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}