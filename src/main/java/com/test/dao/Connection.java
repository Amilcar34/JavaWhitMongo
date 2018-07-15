package com.test.dao;

public abstract class Connection implements ITransaction{

	protected abstract <T> T getConnection();
}
