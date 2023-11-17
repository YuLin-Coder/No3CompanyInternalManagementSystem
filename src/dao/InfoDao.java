package dao;

import java.util.List;

import model.Info;


public interface InfoDao  {
	
	
	
	public void insertBean(Info Info);
	
	public void deleteBean(Info Info);
	
	public void updateBean(Info Info);

	public Info selectBean(String where);
	
	public List<Info> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
