package com.countryservice.CountryService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.countryservice.CountryService.beans.Country;

public interface CountryRepository extends JpaRepository<Country,Integer>{

}
