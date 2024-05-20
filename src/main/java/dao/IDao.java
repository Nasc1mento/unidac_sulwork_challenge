package dao;

import java.util.List;

public interface IDao<T> {

	public void save(T t);

	public T get(Long id);

	public void update(T t);
	
	public void delete(Long id);

	public List<T> getAll();

}
