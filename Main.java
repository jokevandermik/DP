package p3;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class Main {
	public static void main(String[] args) throws ParseException {
		
	
		ReizigerOracleDaoImpl db = new ReizigerOracleDaoImpl();
		OVChipkaartDaoImpl dbov = new OVChipkaartDaoImpl();
		
		Reiziger reiziger = new Reiziger();
		
		reiziger.setVoorletter("J");
		reiziger.setAchternaam("van der Mik");
		
		
		Date datum1 = new SimpleDateFormat("dd/MM/yyyy").parse("17/04/2019");
		
		reiziger.setGBdatum(datum1);

		db.save(reiziger);
		
		OVChipkaart ov = new OVChipkaart();
		
		ov.setKaartNummer(1234567);
		ov.setKlasse(1);
		ov.setId(2);
		ov.setSaldo(234.43);
		dbov.save(ov);
		
		for (Reiziger r : db.findAllByGBdatum("03-12-2002")) {
			System.out.println(r.getVoorletter() + " " + r.getAchternaam());
		}
		
		for (OVChipkaart ovv : dbov.findByReiziger(2)) {
			System.out.println(ovv.getKaartNummer());
		}
	}
} 