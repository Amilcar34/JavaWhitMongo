package com.test.dao;

import java.util.List;

public interface ITransaction{
	
	<E> boolean insert(Object object);
	<T> List<T> getAllEntityes(Object entity);

}
 