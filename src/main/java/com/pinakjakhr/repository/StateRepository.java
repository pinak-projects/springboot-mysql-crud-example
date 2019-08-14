package com.pinakjakhr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pinakjakhr.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

	@Query("select s from State s where s.country.countryId = ?1")
	List<State> findStatesByCountryId(Integer countryId);

}
