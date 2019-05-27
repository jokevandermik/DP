package p1;

import java.util.ArrayList;

public class ReizigerOracleDaoImpl implements ReizigerDao{
	private ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
	
	public ArrayList<Reiziger> findAll(){
		return reizigers;
	}
	
	public ArrayList<Reiziger> findByGBdatum(String GBdatum) {
		ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
		for(Reiziger reiziger : reizigers) {
			if(GBdatum != null) {
				if(reiziger.getGBdatum().equals(GBdatum)) {
					reizigers.add(reiziger);
				}
			}
		}
		return reizigers;
	}
	
	public Reiziger save(Reiziger reiziger){
		if(!reizigers.contains(reiziger)) {
			reizigers.add(reiziger);
		}
		return reiziger;
	}
	
	public Reiziger update(Reiziger reiziger) {
		if(reizigers.contains(reiziger)) {
			reizigers.remove(reiziger);
			reizigers.add(reiziger);
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		if(reizigers.contains(reiziger)) {
			reizigers.remove(reiziger);
			return true;
		}
		return false;
	}
	
	public void CloseConnection() {
		
	}
	
	
}
