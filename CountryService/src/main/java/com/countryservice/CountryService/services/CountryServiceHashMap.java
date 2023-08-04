package com.countryservice.CountryService.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.countryservice.CountryService.beans.Country;
import com.countryservice.CountryService.controllers.AddResponse;



@Service
public class CountryServiceHashMap {

	static HashMap<Integer, Country> countryIdMap;

	public CountryServiceHashMap() {
		countryIdMap = new HashMap<Integer, Country>();

		Country country_1 = new Country(1, "Egypt", "Cairo");
		Country country_2 = new Country(2, "Sudan", "Khartoom");
		Country country_3 = new Country(3, "Saudia", "Riyadh");

		countryIdMap.put(1, country_1);
		countryIdMap.put(2, country_2);
		countryIdMap.put(3, country_3);
	}

	public List<Country> getAllCountries() {
		List<Country> countries = (List<Country>) new ArrayList<Country>(countryIdMap.values());
		return countries;
	}

	public Country getCountryByID(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}

	public Country getCountryByName(String countryName) {
		Country country = null;

		for (int i : countryIdMap.keySet()) {
			if (countryIdMap.get(i).getCountryName().equals(countryName))
				country = countryIdMap.get(i);
		}
		return country;
	}

	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		return country;
	}

	public Country updateCountry(Country country) {
		if (country.getId() > 0)
			countryIdMap.put(country.getId(), country);
		return country;
	}

	public AddResponse deleteCountry(int id) {
		countryIdMap.remove(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Country deleted...");
		return res;
	}
 
	public static int getMaxId() {
		int max = 0;
		for (int id : countryIdMap.keySet())
			if (max <= id)
				max = id;
		return max + 1;
	}

}
