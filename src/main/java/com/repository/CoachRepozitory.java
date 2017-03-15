package com.repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.domain.Coach;

@Repository
public class CoachRepozitory{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CoachRepozitory(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);	
	}
	
	
	public List<Coach> findAll(){
		String sql = "SELECT * FROM coach";
		RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
			public Coach mapRow(ResultSet resultSet, int i) throws SQLException {
				Coach coach = new Coach();
				coach.setId(resultSet.getLong("id_coach"));
				coach.setFirstName(resultSet.getString("firstname"));
				coach.setLastName(resultSet.getString("lastname"));
				coach.setCity(resultSet.getString("city"));
				coach.setPrice(resultSet.getBigDecimal("price"));
				return coach;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	public Coach oneRecord(long id){
		String sql = "SELECT * FROM coach where id_coach=?";
		RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
			public Coach mapRow(ResultSet resultSet, int i) throws SQLException {
				Coach coach = new Coach();
				coach.setId(resultSet.getLong("id_coach"));
				coach.setFirstName(resultSet.getString("firstname"));
				coach.setLastName(resultSet.getString("lastname"));
				coach.setCuntry(resultSet.getString("cuntry"));
				coach.setCity(resultSet.getString("city"));
				coach.setZipCode(resultSet.getString("zipcode"));
				coach.setMob(resultSet.getString("mob"));
				coach.setPrice(resultSet.getBigDecimal("price"));
				return coach;
			}
		};
		
		
		
		return jdbcTemplate.queryForObject(sql, rowMapper,id); 
	}
	
	
	public List<Coach> sortByCity(String city){
		String sql = "SELECT * FROM coach WHERE city=?";
		RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
			public Coach mapRow(ResultSet resultSet, int i) throws SQLException {
				Coach coach = new Coach();
				coach.setId(resultSet.getLong("id_coach"));
				coach.setFirstName(resultSet.getString("firstname"));
				coach.setLastName(resultSet.getString("lastname"));
				coach.setCity(resultSet.getString("city"));
				coach.setPrice(resultSet.getBigDecimal("price"));
				return coach;
			}
		};
		return jdbcTemplate.query(sql, rowMapper,city);
	}
	
	
	public List<Coach> sortByPrice(BigDecimal price){
		String sql = "SELECT * FROM coach WHERE price<=?";
		RowMapper<Coach> rowMapper = new RowMapper<Coach>() {
			public Coach mapRow(ResultSet resultSet, int i) throws SQLException {
				Coach coach = new Coach();
				coach.setId(resultSet.getLong("id_coach"));
				coach.setFirstName(resultSet.getString("firstname"));
				coach.setLastName(resultSet.getString("lastname"));
				coach.setCity(resultSet.getString("city"));
				coach.setPrice(resultSet.getBigDecimal("price"));
				return coach;
			}
		};
		return jdbcTemplate.query(sql, rowMapper,price);
	}
	
	
	
	public boolean addNewCoach(Coach coach){
		String sql = "insert into coach (firstname,lastname,cuntry,city,zipcode,mob,price) values (?,?,?,?,?,?,?)";
		
		Object[] value = new Object[]{coach.getFirstName(),coach.getLastName(),coach.getCuntry(),coach.getCity(),coach.getZipCode(),
				coach.getMob(),coach.getPrice()};
		int result = jdbcTemplate.update(sql,value);
		return result == 1 ? true : false; 
	}
	


}
