package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import database.IDatabase;
import database.MySQLDatabase;
import models.Item;

public class ItemDao implements IDao<Item> {
	
	
	private IDatabase database;
	private static ItemDao instance;

	private ItemDao() {
		this.database = new MySQLDatabase();
	}

	public static ItemDao getInstance() {
		if (instance == null) {
			return new ItemDao();
		}

		return instance;
	}
	

	@Override
	public void save(Item item) {
		String query = "INSERT INTO ITEM VALUES (?, ?);";

		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ps.setLong(1, item.getId());
			ps.setString(2, item.getName());
			ps.setTimestamp(3, item.getDate());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Item get(Long id) {
		Item item = new Item();
		String query = "SELECT * FROM ITEM WHERE ITM_ID = ?;";

		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			item.setId(rs.getLong("ITM_ID"));
			item.setName(rs.getString("ITM_NAME"));
			item.setDate(rs.getTimestamp("ITM_DATE"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return item;
	}

	@Override
	public void update(Item item) {
		String query = "UPDATE ITEM SET IT_NAME = ?, ITM_DATE = ? WHERE USR_ID = ?;";
		
		try {
			PreparedStatement ps = this.database.getConnection().prepareStatement(query);
			ps.setString(1, item.getName());
			ps.setTimestamp(2, item.getDate());
			ps.setLong(3, item.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	@Override
	public List<Item> getAll() {
			List<Item> items = new ArrayList<Item>();
			String query = "SELECT * FROM ITEM;";

			try {
				PreparedStatement ps = this.database.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					Long id = rs.getLong("ITM_ID");
					String name = rs.getString("ITM_NAME");
					Timestamp date = rs.getTimestamp("ITM_DATE");
					Item item = new Item(id, name, date);
					items.add(item);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return items;
	}

	@Override
	public void delete(Long id) {
		String query = "DELETE FROM ITEM WHERE ITM_ID = ?;";
		try {
			
			PreparedStatement preparedStatement = this.database.getConnection().prepareStatement(query);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
