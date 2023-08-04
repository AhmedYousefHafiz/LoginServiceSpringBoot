package com.countryservice.CountryService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.countryservice.CountryService.beans.Country;
import com.countryservice.CountryService.repositories.CountryRepository;
import com.countryservice.CountryService.services.CountryService;

@SpringBootTest(classes = {CountryServiceApplicationTests.class})
class CountryServiceApplicationTests {

	@Mock
	CountryRepository countryRepo;
	@InjectMocks
	CountryService countryService;
	
	@Test
	@Order(1)
	void test_getAllCountries() {
		
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1, "Egypt", "Cairo"));
		countries.add(new Country(2, "Sudan", "Khartoom"));
		countries.add(new Country(3, "Saudia", "Riyadh"));
		
		when(countryRepo.findAll()).thenReturn(countries);
		
		assertEquals(1, countryService.getAllCountries().size());

	}

}
