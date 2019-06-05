package p3;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class Main {
	public static void main(String[] args) throws ParseException {
		
		
		ReizigerOracleDaoImpl db = new ReizigerOracleDaoImpl();
		OVChipkaartDaoImpl dbov = new OVChipkaartDaoImpl();
		ProductDaoImpl dbp = new ProductDaoImpl();

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
		
		Product product1 = new Product();
		product1.setProductNaam("2test3");
		product1.setBeschrijving("Dit is de beschrijving 1");
		product1.setPrijs(50.2);
		product1.setProductNummer(14);
		dbp.save(product1);
		
		Product product2 = new Product();
		product2.setProductNaam("1test4");
		product2.setBeschrijving("Dit is de beschrijving 2");
		product2.setPrijs(10.3);
		product2.setProductNummer(15);
		dbp.save(product2);
		
		dbov.linkProduct(ov, product1);

		for (OVChipkaart ovv : dbov.findByReiziger(2)) {
			System.out.println(ovv.getKaartNummer());
		}
	}
} 