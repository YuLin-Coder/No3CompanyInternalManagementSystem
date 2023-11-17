package dao;

import java.util.List;

import model.Bumen;


public interface BumenDao  {
	
	
	
	public void insertBean(Bumen Bumen);
	
	public void deleteBean(Bumen Bumen);
	
	public void updateBean(Bumen Bumen);

	public Bumen selectBean(String where);
	
	public List<Bumen> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
