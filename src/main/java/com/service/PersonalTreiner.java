package com.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Coach;
import com.repository.PersonalTreinerRepository;

@Service
public class PersonalTreiner implements IPersonalTreiner {
	
	private PersonalTreinerRepository personalTreinerRepository;
	
	@Autowired
	public PersonalTreiner(PersonalTreinerRepository personalTreinerRepository) {
		this.personalTreinerRepository = personalTreinerRepository;
	}

	public boolean log(String login,String pass) {
		String passwordWithDB = personalTreinerRepository.logUser(login);
		return passwordWithDB.equals(pass) ? true : false;
	}

	public boolean register(Coach coach) {
		return personalTreinerRepository.addNewCoach(coach);
	}

	public boolean changePrice(String login,BigDecimal newPrice) {
		return personalTreinerRepository.changePrice(login, newPrice);
	}

	public boolean changeCity(String login,String newCity) {
		System.out.println("Controler : " + login + " / " + newCity);
		return personalTreinerRepository.changeCity(login, newCity);
	}

	public boolean deletePersonal(String login) {
		return personalTreinerRepository.delete(login);
	}

}
