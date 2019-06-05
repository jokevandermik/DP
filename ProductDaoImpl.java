package p3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends OracleBaseDao implements ProductDao{

	public List<Product> findByKaartNummer(int kaartnr) {
		List<Product> producten = new ArrayList<Product>();
		
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			String strQuery = "SELECT * FROM ov_chipkaart_product o " + 
							  "LEFT JOIN product p ON (o.productnummer = p.productnummer) " + 
							  "WHERE o.kaartnummer = " + kaartnr;
			ResultSet rs = myStmt.executeQuery(strQuery);
			
			while(rs.next()) {
				Product p = new Product();
				p.setProductNummer(rs.getInt("PRODUCTNUMMER"));
				p.setProductNaam(rs.getString("PRODUCTNAAM"));
				p.setBeschrijving(rs.getString("BESCHRIJVING"));
				p.setPrijs(rs.getFloat("PRIJS"));
				producten.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return producten;
	}
	
	public Product save(Product product) {
		try {
			Connection myConn = getConnection();
			Statement insertStmt = myConn.createStatement();
			String q = "INSERT INTO " + "product(productnummer, productnaam, beschrijving, prijs) " + "VALUES('" + product.getProductNummer() + "','" + product.getProductNaam() + "', " + product.getBeschrijving() + ",'" + product.getPrijs() + ")";
			ResultSet myRs = insertStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return product;
	}

	public Product update(Product product) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			
			String q = "UPDATE product SET "
					+ "productnummer = '" + product.getProductNummer() + "' "
					+ "productnaam = '" + product.getProductNaam() + "' "
					+ "beschrijving = '" + product.getBeschrijving() + "' "
					+ "prijs = '" + product.getPrijs() + "' ";
			ResultSet myRs = myStmt.executeQuery(q);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return product;
	}

	public boolean delete(Product product) {
		try {
			Connection myConn = getConnection();
			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("DELETE from product "
					+ "WHERE productnummer = " + product.getProductNummer());
			return true;
		} catch (Exception exc) {
			exc.printStackTrace();
			return false;
		}
	}
	
}
