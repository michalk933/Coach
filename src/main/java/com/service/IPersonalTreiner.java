package com.service;

import java.math.BigDecimal;

import com.domain.Coach;

public interface IPersonalTreiner {
	
	boolean log(String login,String pass);
	boolean register(Coach coach);
	boolean changePrice(String login,BigDecimal newPrice);
	boolean changeCity(String login,String newCity);
	boolean deletePersonal(String login);

}
