package p3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDaoImpl extends OracleBaseDao implements OVChipkaartDao {

	public List<OVChipkaart> findByReiziger(int reizigerId) {
		List<OVChipkaart> ovs = new ArrayList<OVChipkaart>();
		
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			String strQuery = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = " + reizigerId;
			ResultSet rs = myStmt.executeQuery(strQuery);
			
			while(rs.next()) {
				OVChipkaart ov = new OVChipkaart();
				ov.setSaldo(rs.getFloat("SALDO"));
				ov.setId(rs.getInt("REIZIGERID"));
				ov.setKaartNummer(rs.getInt("KAARTNUMMER"));
				ovs.add(ov);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ovs;
	}
	
	public OVChipkaart save(OVChipkaart OVChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement insertStmt = myConn.createStatement();
			String q = "INSERT INTO "
					+ "ov_chipkaart(KAARTNUMMER, KLASSE, SALDO, REIZIGERID, GELDIGTOT) "
					+ "VALUES('" + OVChipkaart.getKaartNummer() + "','" + OVChipkaart.getKlasse() + "', " + OVChipkaart.getSaldo() + ",'" + OVChipkaart.getId() + "', to_date('31-12-2017', 'DD-MM-YYYY'))";
			ResultSet myRs = insertStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return OVChipkaart;
	}
	
	public OVChipkaart update(OVChipkaart OVChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			
			String q = "Update OV_CHIPKAART SET "
					+ "KAARTNUMMER = '" + OVChipkaart.getKaartNummer() + "' "
					+ "KLASSE = '" + OVChipkaart.getKlasse() + "' "
					+ "SALDO = '" + OVChipkaart.getSaldo() + "' "
					+ "REIZIGERID = '" + OVChipkaart.getId() + "' ";
			ResultSet myRs = myStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return OVChipkaart;
	}
	
	public boolean delete(OVChipkaart OVChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("delete from OV_CHIPKAART "
					+ "where KAARTNUMMER = " + OVChipkaart.getKaartNummer());
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
}
