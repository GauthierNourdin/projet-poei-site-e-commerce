package org.eclipse.dao;

import java.util.List;

public interface Dao<T> {
	T save(T t);

	void remove(T t);

	T update(T t);

	T findById(int id);

	List<T> findAll();
}