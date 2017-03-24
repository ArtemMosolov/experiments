package com.spring.demo.data.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoUserConfig extends AbstractMongoConfig {
	
	//@Autowired
	//@Qualifier("mongoUserURI")   // mongodb://localhost:27017/local.FLIFO
	@Value(value="${mongoUserURI}")
	private String mongoUserURI_;

	@Override
	protected String getMongoClientURI() {
		return this.mongoUserURI_;
	}
	
	@Bean
    public MongoTemplate mongoUser() throws Exception
    {
        return new MongoTemplate(mongoDbFactory());
    }
	
}
