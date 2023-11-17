package dao;

import java.util.List;

import model.Tongxunlu;


public interface TongxunluDao  {
	
	
	
	public void insertBean(Tongxunlu Tongxunlu);
	
	public void deleteBean(Tongxunlu Tongxunlu);
	
	public void updateBean(Tongxunlu Tongxunlu);

	public Tongxunlu selectBean(String where);
	
	public List<Tongxunlu> selectBeanList(final int start, final int limit,final String where);
	
	public int selectBeanCount(final String where);
	
	
}
