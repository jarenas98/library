package com.library.generic.servicesImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.library.generic.service.GenericService;
import java.util.Optional;

public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getCrudRepository().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	@Override
	public T getById(ID id) {

		Optional<T> obj = getCrudRepository().findById(id);
		
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;

	}
	@Override
	public T add(T t) {
		
		return getCrudRepository().save(t);
	}
	
	@Override
    public T edit(T t) {
		
		return getCrudRepository().save(t);
	}
	
	@Override
	public void delete(ID id) {
	 getCrudRepository().deleteById(id);
	}

	public abstract CrudRepository<T, ID> getCrudRepository();
	
}
