package com.countryservice.CountryService.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.countryservice.CountryService.beans.Country;
import com.countryservice.CountryService.services.CountryService;




@RestController
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public List<Country> getCountries()
	{
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public ResponseEntity<Country> getCountryByID(@PathVariable(value="id") int id)
	{
		try
		{
			Country country = countryService.getCountryByID(id);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getcountries/countryName")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value="name") String name)
	{
		try
		{
			Country country = countryService.getCountryByName(name);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country)
	{
		return countryService.addCountry(country);
	}
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id,@RequestBody Country country)
	{
		try
		{
		Country dbCountry= countryService.updateCountry(id,country);
		return new ResponseEntity<Country>(dbCountry,HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id)
	{
		return countryService.deleteCountry(id);
	}
}
