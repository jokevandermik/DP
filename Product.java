package p3;

public class Product {
	public int productNummer;
	public String productNaam;
	public String beschrijving;
	public double prijs;
	
	public Product() {}
	
	public void setProductNummer(int prodnr) {
		productNummer = prodnr;
	}
	
	public int getProductNummer() {
		return productNummer;
	}
	
	public void setProductNaam(String prodnm) {
		productNaam = prodnm;
	}
	
	public String getProductNaam() {
		return productNaam;
	}
	
	public void setBeschrijving(String bsch) {
		beschrijving = bsch;
	}
	
	public String getBeschrijving() {
		return beschrijving;
	}
	
	public void setPrijs(double pr) {
		prijs = pr;
	}
	
	public double getPrijs() {
		return prijs;
	}
}