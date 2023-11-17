package dao;

import java.util.List;

import model.Renwu;


public interface RenwuDao  {
	
	
	
	public void insertBean(Renwu Renwu);
	
	public void deleteBean(Renwu Renwu);
	
	public void updateBean(Renwu Renwu);

	public Renwu selectBean(String where);
	
	public List<Renwu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
