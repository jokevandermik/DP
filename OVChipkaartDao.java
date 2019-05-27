package p2;

import java.util.List;

public interface OVChipkaartDao {
	public List<OVChipkaart> findByReiziger(int reizigerId);
	public OVChipkaart save(OVChipkaart OVChipkaart);
	public OVChipkaart update(OVChipkaart OVChipkaart);
	public boolean delete(OVChipkaart OVChipkaart);
}