package dao;

import java.util.List;

import model.Gongzuorizhi;


public interface GongzuorizhiDao  {
	
	
	
	public void insertBean(Gongzuorizhi Gongzuorizhi);
	
	public void deleteBean(Gongzuorizhi Gongzuorizhi);
	
	public void updateBean(Gongzuorizhi Gongzuorizhi);

	public Gongzuorizhi selectBean(String where);
	
	public List<Gongzuorizhi> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
