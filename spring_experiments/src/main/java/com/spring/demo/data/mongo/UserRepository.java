package com.spring.demo.data.mongo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.demo.bean.UserBean;

@Repository
public class UserRepository {
	
	@Autowired 
	@Qualifier("mongoUser")
	private MongoTemplate mongoTemplate_i;
	
	@Value(value="${mongoUserCollectionName}")
	private String collectionName;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserBean getUserByLoginMongo(String login) {
		Query query = new Query();
		query.addCriteria(Criteria.where("login").is(login));
		UserBean user = mongoTemplate_i.findOne(query, UserBean.class, "user");
		return user;
	}
	
	public UserBean getUserByLoginJDBC(String login) {
		String sqlSearchQuery = "select * from users";
		List<UserBean> users = jdbcTemplate.query(sqlSearchQuery, new RowMapper<UserBean>() {
            public UserBean mapRow(ResultSet result, int rowNum) throws SQLException {
            	UserBean user = new UserBean();
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                return user;
            }
        });
		return users.get(0);
	}
	
}
