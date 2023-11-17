package dao;

import java.util.List;

import model.Wendang;


public interface WendangDao  {
	
	
	
	public void insertBean(Wendang Wendang);
	
	public void deleteBean(Wendang Wendang);
	
	public void updateBean(Wendang Wendang);

	public Wendang selectBean(String where);
	
	public List<Wendang> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
