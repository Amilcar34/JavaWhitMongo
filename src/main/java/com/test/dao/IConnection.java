package com.test.dao;

public interface IConnection{
	
	 <T> T getConnection();
	<E>boolean insert(Object object);
}
 