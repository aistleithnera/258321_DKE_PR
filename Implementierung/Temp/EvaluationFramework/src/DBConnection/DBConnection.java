package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String url = "jdbc:mysql://e42776-mysql.services.easyname.eu:3306/u48005db23?useSSL=false";
	private static String username = "u48005db23";
	private static String password = "prdke2018";
	
	public static Connection getConnection(){
		
		Connection connection = null; 
		try {
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection; 
	}

}