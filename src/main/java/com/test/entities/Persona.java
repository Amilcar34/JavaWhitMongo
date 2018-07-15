package com.test.entities;

public class Persona {

	private Object _id;
	private String user;
	private String password;
	private String name;
	private long dni;
	
	public Persona() {}
	@Override
	public String toString() {
		return "Persona [user=" + user + ", password=" + password + ", name=" + name + ", dni=" + dni + "]";
	}
	public Persona(String user, String password, String name, long dni) {
		super();
		this.user = user;
		this.password = password;
		this.name = name;
		this.dni = dni;
	}
	
	public Persona(Object _id, String user, String password, String name, long dni) {
		super();
		this._id = _id;
		this.user = user;
		this.password = password;
		this.name = name;
		this.dni = dni;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public Object get_id() {
		return _id;
	}
	public void set_id(Object _id) {
		this._id = _id;
	}
}
