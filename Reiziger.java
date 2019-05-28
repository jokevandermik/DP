package p3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reiziger {
	
	String voorletter;
	String achternaam;
	int id;
	Date bdatum;
	
	public Reiziger() {}
	
	public String getVoorletter() {
		return voorletter;
	}
	
	public void setVoorletter(String nm) {
		voorletter = nm;
	}
	
	public String getAchternaam() {
		return achternaam;
	}
	
	public void setAchternaam(String nm) {
		achternaam = nm;
	}	
	
	public void setId(int reizigerid) {
		id = reizigerid;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getGBdatum() {
		return bdatum; 
	}
	
	public void setGBdatum(Date dtm) {		
		bdatum = dtm;
	}
}
