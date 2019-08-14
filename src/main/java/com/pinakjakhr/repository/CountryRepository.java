package com.pinakjakhr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pinakjakhr.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
