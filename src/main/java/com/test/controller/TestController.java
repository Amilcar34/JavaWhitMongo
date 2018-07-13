package com.test.controller;

import com.test.dao.IConnection;
import com.test.entities.Persona;
import com.test.factory.ConnectionFactory;

public class TestController {

	public <T> boolean insertEntity(T object) {
		
       	IConnection iConnection = ConnectionFactory.getMongoConnection();
    	iConnection.insert(object);
    	return true;
	}
}
