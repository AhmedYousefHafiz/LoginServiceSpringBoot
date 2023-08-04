package com.countryservice.CountryService.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryservice.CountryService.beans.Country;
import com.countryservice.CountryService.controllers.AddResponse;
import com.countryservice.CountryService.repositories.CountryRepository;



@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepo;

	public CountryService() {
	}

	public List<Country> getAllCountries() {
		return countryRepo.findAll();
	}

	public Country getCountryByID(int id) {
		return countryRepo.findById(id).get();
	}

	public Country getCountryByName(String countryName) {
		Country country = null;
        List<Country> countries = countryRepo.findAll();
        
        for(Country con:countries)
        {
        	if(con.getCountryName().equalsIgnoreCase(countryName))
        	{
        		country = con;
        	}
        }
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryRepo.save(country);
		return country;
	}

	public Country updateCountry(int id,Country country) {
		
		Country dbCountry = countryRepo.findById(id).get();
		dbCountry.setCountryCapital(country.getCountryCapital());
		dbCountry.setCountryName(country.getCountryName());
		countryRepo.save(dbCountry);
		return dbCountry;
	}

	public AddResponse deleteCountry(int id) {
		countryRepo.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Country deleted...");
		return res;
	}
 
	public  int getMaxId() {
		return countryRepo.findAll().size() +1 ;
	}

}
