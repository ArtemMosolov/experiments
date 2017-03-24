package com.spring.demo.data.mongo;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClientURI;

public abstract class AbstractMongoConfig {
	
	protected abstract String getMongoClientURI();
	
    protected MongoClientURI mongoUri() throws Exception
    {
        MongoClientURI clientURI = new MongoClientURI(getMongoClientURI());
        return clientURI;
    }
	
	protected final MongoDbFactory mongoDbFactory() throws Exception
    {
        return new SimpleMongoDbFactory(mongoUri());
    }
		
}
