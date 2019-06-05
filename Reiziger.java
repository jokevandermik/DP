package p2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
	
	String voorletter;
	String achternaam;
	int id;
	Date bdatum;
	private ArrayList<OVChipkaart> ovKaarten = new ArrayList<OVChipkaart>();
	
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
	
	public void voegOvtoe(OVChipkaart ov) {
		if (!this.ovKaarten.contains(ov)){
			this.ovKaarten.add(ov);
		}
	}
}