package com.test.dao;

import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.test.entities.Persona;

public class MongoConnection extends Connection{
	
	private static final Object[] T = null;
	private static DB database = null;
	private static MongoClient mongoClient = null;
	private static Gson gson = new Gson();
	
	public MongoConnection() {
		MongoConnection.database = getConnection();
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	protected DB getConnection() {
				
		if (database == null || mongoClient == null) {
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
		database = getConnection();	
		DBObject dbObject = (BasicDBObject) JSON.parse(gson.toJson(elemnt));
		DBCollection collection;
		collection = database.getCollection(elemnt.getClass().getSimpleName());
		collection.insert(dbObject);
		mongoClient.close();
		return true;
	}

	public <T> List<T> getAllEntityes(Object entity) {
		
		database = getConnection();
		DBCollection collection = database.getCollection(entity.getClass().getSimpleName());
		DBCursor cursor = collection.find();
		
		Iterator<DBObject> iterator = cursor.iterator();

		try {
			Class classEntity = Class.forName("com.test.entities." + entity.getClass().getSimpleName());
		//	Field[] fields = classEntity.getDeclaredFields();
			
			while (cursor.hasNext()) {
				DBObject dbObject = (DBObject) cursor.next();
				String string = dbObject.toString();
				Object objectClass = gson.fromJson(string, Class.forName("com.test.entities." + entity.getClass().getSimpleName()));
				
				
				System.out.println(objectClass.getClass());
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Persona persona;
			
		return filter(persona.getClass(), collection.find());
	}
	
	
	static <T> List<T> filter(Class<T> clazz, List<?> items) {
	    return (List<T>) items.stream()
	        .filter(clazz::isInstance)
	        .map(clazz::cast)
	        .collect(Collectors.toList());
	}
}
