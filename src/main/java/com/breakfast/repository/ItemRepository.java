package com.breakfast.repository;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.breakfast.models.Item;

public interface ItemRepository {
	@Query(value = "INSERT INTO ITEM (ITM_NAME, ITM_DATE) VALUES (:ITM_NAME, :ITM_DATE);", nativeQuery = true)
	public void save(@Param("ITM_NAME") String name, @Param("ITM_DATE") Date cpf);

	@Query(value = "DELETE FROM ITEM WHERE ITM_ID = ?;", nativeQuery = true)
	public void delete(Long id);
	
	@Query(value = "UPDATE ITEM SET ITM_NAME = ?, ITM_DATE = ? WHERE ITM_ID = ?;", nativeQuery = true)
	public void update(String name, Date date);
	
	@Query(value = "SELECT * FROM ITEM WHERE ITM_ID = ?;", nativeQuery = true)
	public Item get(Long id);
	
	@Query(value = "SELECT * FROM ITEM;", nativeQuery = true)
	public List<Item> getAll();
	
}