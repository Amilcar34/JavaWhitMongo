package com.test.contracs;

import java.util.ArrayList;
import java.util.List;

public class Entity<T> {
	
	private T type;
	
	public Entity() {
		type = null;
	}

	public T getTypet() {
		return type;
	}

	public void setType(Object type) {
		try {
			this.type = (T) Class.forName("com.test.entities." + type.getClass().getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
