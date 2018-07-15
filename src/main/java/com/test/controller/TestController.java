package com.test.controller;

import java.util.List;

import com.test.dao.ITransaction;
import com.test.entities.Persona;
import com.test.factory.ConnectionFactory;

public class TestController {

	public <T> boolean insertEntity(T entity) {
		
       	ITransaction iConnection = ConnectionFactory.getMongoConnection();
    	iConnection.insert(entity);
    	return true;
	}
	
	public <T> T getAllEnrtity(T entity) {
		
		ITransaction iConnection = ConnectionFactory.getMongoConnection();
		iConnection.<Persona>getAllEntityes(entity);
		System.out.println("paso el controller");
		return (T) new TestController();
	}
}
