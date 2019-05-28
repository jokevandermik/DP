package p3;

import java.sql.*;

public class OracleBaseDao {
	
	protected Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String username = "system";
		String password = "oracle";
		
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