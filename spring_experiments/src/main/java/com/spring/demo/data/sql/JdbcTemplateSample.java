package com.spring.demo.data.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.demo.bean.UserBean;

@Component
public class JdbcTemplateSample {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void select() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from t_actor", Integer.class);

		int countOfActorsNamedJoe = this.jdbcTemplate
				.queryForObject("select count(*) from t_actor where first_name = ?", Integer.class, "Joe");

		String lastName = this.jdbcTemplate.queryForObject("select last_name from t_actor where id = ?",
				new Object[] { 1212L }, String.class);

		UserBean user = this.jdbcTemplate.queryForObject("select first_name, last_name from t_actor where id = ?",
				new Object[] { 1212L }, new RowMapper<UserBean>() {
					public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserBean user = new UserBean();
						user.setLogin(rs.getString("login"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});

		List<UserBean> users = this.jdbcTemplate.query("select first_name, last_name from t_actor",
				new RowMapper<UserBean>() {
					public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
						UserBean user = new UserBean();
						user.setLogin(rs.getString("login"));
						user.setPassword(rs.getString("password"));
						return user;
					}
				});
	}
	
	public void insert_updated_delete() {
		this.jdbcTemplate.update(
		        "insert into t_actor (first_name, last_name) values (?, ?)",
		        "Leonor", "Watling");
		
		this.jdbcTemplate.update(
		        "update t_actor set last_name = ? where id = ?",
		        "Banjo", 5276L);
		
		this.jdbcTemplate.update(
		        "delete from actor where id = ?",
		        Long.valueOf(100500));
	}

}
