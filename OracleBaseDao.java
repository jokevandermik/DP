package p2;

import java.sql.*;

public class OracleBaseDao {
	
	protected Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String username = "system";
		String password = "17Am09Re16";
		
		Connection myConn = null;

		try {
			myConn = DriverManager.getConnection(url, username, password);		
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return myConn;
		
	}
	
	public void closeConnection(Connection myConn) throws SQLException{
	}
}