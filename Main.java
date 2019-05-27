package p1;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws ParseException {
		
		ReizigerOracleDaoImpl db = new ReizigerOracleDaoImpl();
		
		Reiziger reiziger1 = new Reiziger();
		reiziger1.setNaam("Job");
		db.save(reiziger1);
		for (Reiziger r : db.findAll()) {
			System.out.println(r.getNaam());
		}
		System.out.println("1");
		
		Reiziger reiziger2 = new Reiziger();
		reiziger2.setNaam("Job2");
		db.save(reiziger2);
		for (Reiziger r : db.findAll()) {
			System.out.println(r.getNaam());
		}
		System.out.println("2");
		
		Reiziger reiziger3 = new Reiziger();
		reiziger3.setNaam("Job3");
		db.save(reiziger3);
		
		for (Reiziger r : db.findAll()) {
			System.out.println(r.getNaam());
		}
		System.out.println("3");
		
		reiziger1.setNaam("JobNieuw");
		db.update(reiziger1);
		for (Reiziger r : db.findAll()) {
			System.out.println(r.getNaam());
		}
		System.out.println("4");
		
		Date datum = new SimpleDateFormat("dd/MM/yyyy").parse("25/04/2019");

		reiziger1.setGBdatum(datum);
		
		for (Reiziger reiziger : db.findByGBdatum(datum.toString())) {
			System.out.println(reiziger.getNaam());
		}
		
	}
}