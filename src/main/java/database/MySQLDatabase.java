package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements IDatabase {
	
	final String HOST_NAME = "127.0.0.1";
	final String DATABASE = "BREAKFAST";
	final String USER_NAME = "root";
	final String PASSWORD = "root";
	final String PORT_NUMBER = "3306";
 
	@Override
	public Connection getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://"+HOST_NAME+":"+PORT_NUMBER+"/"+DATABASE,USER_NAME,PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}