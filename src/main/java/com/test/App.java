package com.test;

import com.mongodb.DB;
import com.test.controller.TestController;
import com.test.dao.ITransaction;
import com.test.dao.MongoConnection;
import com.test.entities.Dueño;
import com.test.entities.Mascota;
import com.test.entities.Persona;
import com.test.factory.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	TestController controller = new TestController();
//    	Persona persona = new Persona("Mabel", "2222222", "Mabel", 222222);
//    	controller.insertEntity(persona);
//    	
//    	Mascota mascota = new Mascota("leo", new Dueño("mabel"));
//    	controller.insertEntity(mascota);
//    	
//    	Dueño dueño = new Dueño("Rolon");
//    	controller.insertEntity(dueño);
    	controller.getAllEnrtity();
    	
    }
}
