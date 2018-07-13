package com.test.dao;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.google.gson.Gson;
import com.test.entities.Persona;

public class MongoConnection implements IConnection{
	
	private static DB database = null;
	private static MongoClient mongoClient = null;
	
	public MongoConnection() {
		MongoConnection.database = getConnection();

	}
	
	public DB getConnection() {
				
		if (database == null) {
			try {
				mongoClient = new MongoClient("localhost", 27017);	
				database = mongoClient.getDB("TestFull");
			} catch (UnknownHostException e) { 
				e.printStackTrace();	
			}
		}
		return database;		
	}

	public boolean insert(Object elemnt) {
		Gson gson = new Gson();
		DBObject dbObject = (BasicDBObject) JSON.parse(gson.toJson(elemnt));
		DBCollection collection;
		collection = database.getCollection(elemnt.getClass().getSimpleName());
		collection.insert(dbObject);
		mongoClient.close();
		return true;
	}
	

}
