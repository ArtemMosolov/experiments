package com.spring.demo.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.demo.bean.UserBean;

@Repository
public class UserRepository {
	
	@Autowired 
	@Qualifier("mongoUser")
	private MongoTemplate mongoTemplate_i;
	
	@Value(value="${mongoUserCollectionName}")
	private String collectionName;
	
	public UserBean getUserByLogin(String login) {
		Query query = new Query();
		query.addCriteria(Criteria.where("login").is(login));
		UserBean user = mongoTemplate_i.findOne(query, UserBean.class, "user");
		return user;
	}
	
}
