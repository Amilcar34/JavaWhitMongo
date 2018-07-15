package com.test.controller;

import java.util.List;

import com.test.dao.ITransaction;
import com.test.entities.Persona;
import com.test.factory.ConnectionFactory;

public class TestController {

	public <T> boolean insertEntity(T object) {
		
       	ITransaction iConnection = ConnectionFactory.getMongoConnection();
    	iConnection.insert(object);
    	return true;
	}
	
	public <T> T getAllEnrtity() {
		
		ITransaction iConnection = ConnectionFactory.getMongoConnection();
		iConnection.<Persona>getAllEntityes(new Persona());
		System.out.println("paso el controller");
		return (T) new TestController();
	}
}
