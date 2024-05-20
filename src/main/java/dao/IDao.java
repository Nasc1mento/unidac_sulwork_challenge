package dao;

public interface IDao<T> {

	public T save(T t);

	public T get(int id);

	public T update(T t);

	public T[] getAll();

}
