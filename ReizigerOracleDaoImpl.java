package p3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao{	
	
	private List<Reiziger> reizigers = new ArrayList<Reiziger>();

	public List<Reiziger> findAll(){
		return reizigers;
	}
	
	public List<Reiziger> findAllByGBdatum(String GBdatum){
		
		List<Reiziger> list = new ArrayList<Reiziger>();
		
		try {
			Connection myConn = getConnection();
			
			Statement myStmt = myConn.createStatement();
			String strQuery = "SELECT * FROM REIZIGER WHERE gebortedatum = to_date(" + "'" + GBdatum + "'" + ", 'DD-MM-YYYY')";
			
			ResultSet rs = myStmt.executeQuery(strQuery);
			
			while(rs.next()) {
				Reiziger reiziger = new Reiziger();
				reiziger.setVoorletter(rs.getString("VOORLETTERS"));
				reiziger.setAchternaam(rs.getString("ACHTERNAAM"));
				list.add(reiziger);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	public Reiziger save(Reiziger reiziger) {
		try {
			int reizigeridint = 0;
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM reiziger ORDER BY reizigerid");
			while (myRs.next()) {
				reizigeridint = myRs.getInt("reizigerid");
			}
			
			reizigeridint = reizigeridint + 1;
			reiziger.setId(reizigeridint);
			String voorletter = reiziger.getVoorletter();
			String achternaam = reiziger.getAchternaam();
			
			Statement insertStmt = myConn.createStatement();
			insertStmt.executeQuery("INSERT INTO reiziger(reizigerid, voorletters, achternaam)	VALUES('"+ reizigeridint + "','" + voorletter + "','" + achternaam +  "')");
		
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return reiziger;

	}
	public Reiziger update(Reiziger reiziger) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			
			String voorletter = reiziger.getVoorletter();
			String achternaam = reiziger.getAchternaam();
			
			String q = "Update REIZIGER SET voorletters = '" + voorletter + "', ACHTERNAAM = '" + achternaam + "' where REIZIGERID = " + reiziger.getId();
			ResultSet myRs = myStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return reiziger;		
	}
	public boolean delete(Reiziger reiziger) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("DELETE FROM REIZIGER WHERE reizigerid = " + reiziger.getId());
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}		
	}
}
