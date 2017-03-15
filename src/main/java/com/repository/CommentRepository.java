package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.domain.Coach;
import com.domain.Comment;

@Repository
public class CommentRepository {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CommentRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Comment> findComent(Long id_coach){
		String sql = "select * from comment where id_coach=?";
		
		RowMapper<Comment> rowMapper = new RowMapper<Comment>() {
			public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
				Comment comment = new Comment();
				comment.setDescrip(resultSet.getString("descrip"));
				comment.setAuthor(resultSet.getString("author"));
				return comment;
			}
		};
		return jdbcTemplate.query(sql, rowMapper,id_coach);
	}
	
	
	public boolean addComent(Comment comment){
		String sql ="insert into comment (descrip,author,id_coach) values (?,?,?)";
		Object[] obj = new Object[]{comment.getDescrip(),comment.getAuthor(),comment.getId_coach()};
		int update = jdbcTemplate.update(sql,obj);
		return update == 1 ? true : false;
	}
	
	
	/*
	 * public boolean addNewCoach(Coach coach){
		String sql = "insert into coach (firstname,lastname,cuntry,city,zipcode,mob,price) values (?,?,?,?,?,?,?)";
		
		Object[] value = new Object[]{coach.getFirstName(),coach.getLastName(),coach.getCuntry(),coach.getCity(),coach.getZipCode(),
				coach.getMob(),coach.getPrice()};
		int result = jdbcTemplate.update(sql,value);
		return result == 1 ? true : false; 
	}
	
	 */
	
}
