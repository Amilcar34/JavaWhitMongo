package com.test.factory;

import java.net.UnknownHostException;

import com.test.dao.ITransaction;
import com.test.dao.MongoConnection;
import com.test.dao.XAMPConnection;
import com.test.entities.Persona;

public class ConnectionFactory {
	
	private static MongoConnection iConnectionMongo = null;
	private static XAMPConnection iConnectionXAMP = null;
	
	public static MongoConnection getMongoConnection(){
		
		if(iConnectionMongo == null) {
			iConnectionMongo = new MongoConnection();
		}
		return iConnectionMongo;
	}

	public static XAMPConnection getXAMPConnection(){
		
		if(iConnectionXAMP == null) {
			iConnectionXAMP = new XAMPConnection();
		}
		return iConnectionXAMP;
	}
}
