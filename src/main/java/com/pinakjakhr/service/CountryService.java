package com.pinakjakhr.service;

import static com.pinakjakhr.constants.APIConstants.COUNTRY_DETAILS_NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.pinakjakhr.entity.Country;
import com.pinakjakhr.repository.CountryRepository;;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public Country saveCountryDetails(Country country) {
		return countryRepository.save(country);
	}

	public Country editCountryDetails(Country country) {
		checkCountryDetailsExistance(country.getCountryId());
		return countryRepository.save(country);
	}

	private void checkCountryDetailsExistance(Integer countryId) {
		if (!countryRepository.existsById(countryId)) {
			throw new ResourceNotFoundException(COUNTRY_DETAILS_NOT_FOUND);
		}
	}

	public Country getCountryDetails(Integer countryId) {
		return countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException(COUNTRY_DETAILS_NOT_FOUND));
	}

	public void deleteCountryDetails(Integer countryId) {
		checkCountryDetailsExistance(countryId);
		countryRepository.deleteById(countryId);
	}

	public List<Country> getAllCountries() {
		return Optional.ofNullable(countryRepository.findAll()).orElse(new ArrayList<>());
	}

}
