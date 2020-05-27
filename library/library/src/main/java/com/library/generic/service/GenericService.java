package com.library.generic.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T,ID extends Serializable> {
	
    List<T> getAll();
	T getById(ID id);
	T add(T t);
	T edit(T t);
	void delete(ID id);
	

}
