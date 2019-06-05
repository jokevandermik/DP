package p3;

import java.util.List;

public interface ProductDao {
	public List<Product> findByKaartNummer(int kaartnr);
	public Product save(Product product);
	public Product update(Product product);
	public boolean delete(Product product);
}
