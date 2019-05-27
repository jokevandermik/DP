package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class OracleBaseDao {
	private String connectionString = "jdbc:oracle:thin:@localhost:1521/xe";
	private String username = "OV";
	private String password = "ov";
	
	protected Connection getConnection() {
		try {
			return DriverManager.getConnection(this.connectionString, this.username, this.password);		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}