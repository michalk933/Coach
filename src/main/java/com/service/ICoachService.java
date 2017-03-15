package com.service;

import java.math.BigDecimal;
import java.util.List;

import com.domain.Coach;

public interface ICoachService {
	
	// list all coach
	List<Coach> listCoach();
	// Cocha by id
	Coach findCoachById(long id);
	// Sort city
	List<Coach> findCoachByCity(String city);
	// Sort price
	List<Coach> findCoachByPrice(BigDecimal price);
	// add coach
	boolean addNewCoach(Coach coach);

}
