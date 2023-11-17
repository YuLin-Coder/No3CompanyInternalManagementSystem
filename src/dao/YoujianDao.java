package dao;

import java.util.List;

import model.Youjian;


public interface YoujianDao  {
	
	
	
	public void insertBean(Youjian Youjian);
	
	public void deleteBean(Youjian Youjian);
	
	public void updateBean(Youjian Youjian);

	public Youjian selectBean(String where);
	
	public List<Youjian> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
