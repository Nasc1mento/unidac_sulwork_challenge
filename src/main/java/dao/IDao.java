package dao;

import java.util.List;

public interface IDao<T> {

	public T save(T t);

	public T get(int id);

	public T update(T t);

	public List<T> getAll();

}
