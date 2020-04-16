package application;
import java.sql.*;

public class sqliteConnection {
	public static Connection Connector() {
		Connection conn=null;
		try {		
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:obligDB.sqlite");
			return conn;
		} catch (Exception e) {
			
		}
		return conn;
	}
	

}
