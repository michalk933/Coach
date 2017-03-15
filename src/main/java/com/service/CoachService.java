package com.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Coach;
import com.repository.CoachRepozitory;

@Service
public class CoachService implements ICoachService {
	
	private CoachRepozitory coachRepozitory;

	@Autowired
	public CoachService(CoachRepozitory coachRepozitory) {
		this.coachRepozitory = coachRepozitory;
	}

	
	public List<Coach> listCoach() {
		return coachRepozitory.findAll();
	}

	public Coach findCoachById(long id) {
		return coachRepozitory.oneRecord(id);
	}

	public List<Coach> findCoachByCity(String city) {
		return coachRepozitory.sortByCity(city);
	}

	public List<Coach> findCoachByPrice(BigDecimal price) {
		return coachRepozitory.sortByPrice(price);
	}


	public boolean addNewCoach(Coach coach) {
		return coachRepozitory.addNewCoach(coach);
	}
	

	
	
	

}
