package com.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.domain.Coach;

@Repository
public class PersonalTreinerRepository {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonalTreinerRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public String logUser(String login){
		Map<String,Object> result=null;
		String pass = null;
		
		String sql = "select password_coach from coach where login=?";
		try{
			result = jdbcTemplate.queryForMap(sql,login);
			pass = (String)result.get("password_coach");
		}catch (EmptyResultDataAccessException e) {
			pass = "empty";
		}
		return pass;	
	}
		
	public boolean addNewCoach(Coach coach){
		String sql = "insert into coach (firstname,lastname,cuntry,city,zipcode,mob,price,password_coach,login) values (?,?,?,?,?,?,?,?,?)";
		
		Object[] value = new Object[]{coach.getFirstName(), coach.getLastName(), coach.getCuntry(), 
				coach.getCity(), coach.getZipCode(),coach.getMob(),coach.getPrice(),coach.getPassword(), coach.getLogin()};
		int result = jdbcTemplate.update(sql,value);
		return result == 1 ? true : false; 
	}
	
	public boolean changePrice(String login, BigDecimal newPrice){
		String sql = "Update coach set price=? where login=?";
		Object[] object = new Object[]{newPrice,login};
		int result =jdbcTemplate.update(sql,object);
		return result == 1 ? true : false; 
	}
	
	public boolean changeCity(String login,String newCity){
		String sql = "Update coach set city=? where login=?";
		Object[] object = new Object[]{newCity,login};
		int result =jdbcTemplate.update(sql,newCity,login);
		return result == 1 ? true : false; 
	}
	
	public boolean delete(String login){
		String sql = "delete from coach where login=?";
		Object[] object = new Object[]{login};
		int result =jdbcTemplate.update(sql,object);
		return result == 1 ? true : false;
	}

	

}
